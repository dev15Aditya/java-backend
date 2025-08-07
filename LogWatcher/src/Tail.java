
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tail {
    public static List<String> tail(String filePath, int numLines) throws IOException{
        List<String> lines = new ArrayList<>();

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            long length = file.length();
            long position = length - 1;
            int linesFound = 0;

            StringBuilder line = new StringBuilder();

            while(position >= 0 && linesFound < numLines) {
                file.seek(position);
                char c = (char) file.read();

                if(c == '\n') {
                    if(line.length() > 0) {
                        lines.add(line.reverse().toString());
                        line = new StringBuilder();
                        linesFound++;
                    } else {
                        line.append(c);
                    }
                    position--;
                }

                if(line.length() > 0) {
                    lines.add(line.reverse().toString());
                }
            }

            Collections.reverse(lines);
            return lines;
        }
    }
}
