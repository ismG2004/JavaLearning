import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static long lines = 0;
    static void incrementLines() {
        lines++;
    }

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\user\\IdeaProjects\\TEST1\\test.txt"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        int count = countLineBufferedReader("C:\\Users\\user\\IdeaProjects\\TEST1\\test.txt");
        for (int i = 0; i <= count; i++) {
            Runnable task = new ReadFile(reader);
            Thread worker = new Thread(task);
            worker.setName(String.valueOf(i));
            worker.start();

        }
    }

    public static int countLineBufferedReader(String fileName) {
//        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null)
                incrementLines();
//                lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) lines;
    }


}