//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Test {
//    private int counter;
//
//    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
//        MeowExample test = new MeowExample();
//        test.doWork();
//    }
//
//    public void doWork() throws FileNotFoundException, InterruptedException {
//        FileReader fileReader = new FileReader("C:\\Users\\user\\IdeaProjects\\TEST1\\test.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public  void run() {
//                try {
//                    while (bufferedReader.ready()) {
//                        counter++;
//                        System.out.println("Thread 1 : " + counter + "\t" + bufferedReader.readLine());
////                        System.out.println("Thread 1 " + counter);
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public  void run() {
//                try {
//                    while (bufferedReader.ready()) {
////                        System.out.println("Thread 2 :"+bufferedReader.readLine());
//                        counter++;
//                        System.out.println("Thread 2 : " + counter + "\t" + bufferedReader.readLine());
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
//
//        System.out.println("General counter: " + counter);
//    }
//
//}
