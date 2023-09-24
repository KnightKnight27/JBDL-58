package LEC_5_Multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // DAEMON THREADS
        // scenario is that your application is making trades
        // and u have a different thread which is listening to market update price server
       Thread t1 = new Thread(()->{
           System.out.println("HEY I executed for 10 seconds");
           try {
               Thread.sleep(10000);

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
       t1.setDaemon(true);
       t1.start();
       System.out.println("MY MAIN THREAD IS OVER");
        // PARALLEL STREAMS

        List<Integer> arr = Arrays.asList(2,7,9,10,12,18);
        arr.parallelStream().filter(x->x%2==0).forEach(x->{
            System.out.print(x);
            System.out.println(Thread.currentThread());
        });
        /**
         * Lec 5 Learning more about threads, synchronization,critical section,parallel streams.
         HOW TO ADD NUMBERS FROM 1 TILL 1000 using multiple threads
         shutdown your executor service means it wont take any more runnables
         */

          ExecutorService executorService = Executors.newFixedThreadPool(10);
                  for(int i=1;i<=100;i++){
                      executorService.submit(new Adder(i));
                  }
                  executorService.shutdown();
                  System.out.print(Adder.final_ans);
                  List<Thread> listOfThreads = new ArrayList<>();
                  for(int i=1;i<=100000;i++){
                      Thread t = new Thread(new Adder(i));
                      t.start();
                      listOfThreads.add(t);
                  }
                  listOfThreads.stream().forEach(t-> {
                      try {
                          t.join();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  });
                  System.out.print(Adder.final_ans);



    }
}
