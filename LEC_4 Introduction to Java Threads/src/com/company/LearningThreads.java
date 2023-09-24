package company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Other Thread is here");
    }
}
class NumberPrinter implements Runnable{
    int data;

    NumberPrinter(int data){
        this.data = data;
    }
    @Override
    public void run() {
        /// NETWORK CALL ANDD ALL THAT LOGIC
        //  RETURNS THE ADDRESS OF THE IMAGE
        System.out.println(data + " " + "th IMAGE GOT DOWNALODED");
    }
}
class ImageDownloader implements Callable<String>{
    int imageN;

    ImageDownloader(int N){
        imageN = N;
    }
    @Override
    public String call() throws Exception {
        // FOR DOWNLOADING AN IMAGE I WILL WRITE SOME DUMMY LOGIC
        // MAYBE I CAME A NETWORK CALL
        return "Adress of image:" +  Integer.toString(imageN);
    }
}
public class LearningThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ImageDownloader imageDownloader = new ImageDownloader(1);
        FutureTask<String> imageFutureTask = new FutureTask<>(imageDownloader);
        Thread t = new Thread(imageFutureTask);
        t.start();
        String addresss = imageFutureTask.get();
        System.out.println(addresss);
        /**
         * What are threads ??
         *  Smallest unit of process
         *  Two type of Tasks
         *  CPU HEAVY TASKS
         *  IO BOUND TASKS
         *  Context switching is pre empting a thread and push another thread for execution
         *  MACHINE LEARNING MODELS CPU HEAVY OPERATIONS SINGLE THREADED BETTER
         *  DOWNLOAD FROM NETWORK, USER HAS TO INTERACT WITH APPLICATION -> MULTITHREADING IS BETTER
         */
        /*
        List<Thread> allThreads = new ArrayList<>();
        for(int i=1;i<20;i++) {
            NumberPrinter numberPrinter1 = new NumberPrinter(i);
            Thread t1 = new Thread(numberPrinter1);
            allThreads.add(t1);
            t1.start();
        }
        for(Thread i:allThreads){
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("I AM DONE DOWNLOADING");
        MyThread  myThread = new MyThread();
        myThread.start();
        System.out.println("Main thread is here");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){

        }
        System.out.println("Hellooooo HELLO");
         */
    }
}
