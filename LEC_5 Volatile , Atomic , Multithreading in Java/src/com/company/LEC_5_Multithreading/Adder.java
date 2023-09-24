package LEC_5_Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Runnable{

    static AtomicInteger final_ans = new AtomicInteger(0);
    int number_to_add;
    Adder(int number_to_add){
        this.number_to_add = number_to_add;
    }
    @Override
    public void run(){
        // only on thread is allowed at one time
        final_ans.addAndGet(1);
        // your run function doesnt even know what to add ?
    }
}
