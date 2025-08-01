
import java.io.*;
import java.util.*;

public class JsonUtils {

    // Reads tasks from file
    public static List<Task> readTasks(String filePath) {
        List<Task> tasks = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            writeTasks(filePath, tasks); // Create file with empty list
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }

            String json = sb.toString().trim();

            if (!json.startsWith("[") || !json.endsWith("]"))
                return tasks;
            json = json.substring(1, json.length() - 1).trim(); // remove [ and ]

            if (json.isEmpty())
                return tasks;

            String[] items = json.split("},\\s*\\{");

            for (int i = 0; i < items.length; i++) {
                String item = items[i].trim();
                if (!item.startsWith("{"))
                    item = "{" + item;
                if (!item.endsWith("}"))
                    item = item + "}";

                Map<String, String> map = parseJsonObject(item);

                Task task = new Task(
                        map.get("id"),
                        map.get("description"),
                        Status.valueOf(map.get("status").toUpperCase().replace("-", "_")),
                        new Date(Long.parseLong(map.get("createdAt"))),
                        new Date(Long.parseLong(map.get("updatedAt"))));

                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Failed to read tasks: " + e.getMessage());
        }

        return tasks;
    }

    // Writes tasks to file
    public static void writeTasks(String filePath, List<Task> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("[\n");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                bw.write("  {\n");
                bw.write("    \"id\": " + task.getId() + ",\n");
                bw.write("    \"description\": \"" + escape(task.getDescription()) + "\",\n");
                bw.write("    \"status\": \"" + task.getStatus() + "\",\n");
                bw.write("    \"createdAt\": " + task.getCreatedAt().getTime() + ",\n");
                bw.write("    \"updatedAt\": " + task.getUpdatedAt().getTime() + "\n");
                bw.write("  }" + (i < tasks.size() - 1 ? "," : "") + "\n");
            }
            bw.write("]\n");
        } catch (IOException e) {
            System.out.println("Failed to write tasks: " + e.getMessage());
        }
    }

    // Helper: escape quotes in description
    private static String escape(String text) {
        return text.replace("\"", "\\\"");
    }

    // Minimal JSON object parser (String → Map)
    private static Map<String, String> parseJsonObject(String json) {
        Map<String, String> map = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // remove {}
        String[] pairs = json.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        for (String pair : pairs) {
            String[] kv = pair.split(":", 2);
            if (kv.length != 2)
                continue;
            String key = kv[0].trim().replaceAll("^\"|\"$", "");
            String value = kv[1].trim().replaceAll("^\"|\"$", "");
            map.put(key, value);
        }

        return map;
    }
}
