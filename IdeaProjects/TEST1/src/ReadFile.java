import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements Runnable {
    BufferedReader bReader = null;

    ReadFile(BufferedReader reader) {
        this.bReader = reader;
    }

    public synchronized void run() {
        String line;
        try {
            while ((line = bReader.readLine()) != null) {

                try {
                    System.out.println(Thread.currentThread().getName() + ": " + line);
                    Thread.currentThread().stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}