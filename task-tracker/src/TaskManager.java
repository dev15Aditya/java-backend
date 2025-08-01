
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private String filePath = "tasks.json";

    public TaskManager() {
        this.tasks = JsonUtils.readTasks(filePath);
    }
}
