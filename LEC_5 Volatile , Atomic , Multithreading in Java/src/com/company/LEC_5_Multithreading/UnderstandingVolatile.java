package LEC_5_Multithreading;

public class UnderstandingVolatile {
    private static volatile int x = 0;
    static class WriterThread implements Runnable {
        @Override
        public void run(){
            int value_x = x;
            while(value_x<10){
                System.out.println("Writer thread Incrementing value of x");
                x = ++ value_x;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    static class ReaderThread implements Runnable {
        @Override
        public void run(){
            int read_x = x;
            while(read_x < 10){
                if(read_x != x){
                    System.out.println("Reader thread saw something");
                    read_x = x;
                }
            }
        }
    }
    public static void main(String[] args) {
        /**
         * Bcz each thread operates on a core and it has its own cache so the writes to any varaible from a thread may cause issues
         *
         */
        WriterThread writerThread = new WriterThread();
        ReaderThread readerThread = new ReaderThread();
        Thread t1 = new Thread(readerThread);
        Thread t2 = new Thread(writerThread);
        t1.start();
        t2.start();


    }
}
