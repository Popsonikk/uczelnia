import java.util.Scanner;

public class Main {

    static class Buffer{
        private final char[] buffer;
        private int readIndex;
        private int writeIndex;
        private int size;

        public Buffer(int size) {
            this.size = size;
            this.buffer=new char[size];
        }
        int nextIndex(int index)
        {
            return (index+1)%size;
        }

        synchronized void putChar(char value) throws InterruptedException {
            while(nextIndex(writeIndex)==readIndex)
                wait();
            buffer[writeIndex]=value;
            writeIndex=nextIndex(writeIndex);
            notifyAll();
        }
       synchronized char getChar() throws InterruptedException {
            while(readIndex==writeIndex)
            {
                wait();
            }
            char x= buffer[readIndex];
            readIndex=nextIndex(readIndex);
            notifyAll();
            return x;
        }
    }
    static class Producent extends  Thread {
        private Buffer buffer;

        public Producent(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    char[] line = scanner.nextLine().toCharArray();
                    boolean lastStar = false;
                    for (char c : line) {
                        if (c == '*' && lastStar) {
                            lastStar = false;
                            buffer.putChar('&');
                            continue;
                        }

                        if (c == '*') {
                            lastStar = true;
                            continue;
                        }
                        buffer.putChar(c);
                    }


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class Consumer extends Thread
    {
        private Buffer buffer;
        private int recieved=0;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }
        @Override
        public void run()
        {
            StringBuilder builder=new StringBuilder();
            while(true)
            {
                try {
                    builder.append(buffer.getChar());
                    recieved++;
                    if(recieved==80)
                    {
                        System.out.println(builder);
                        recieved=0;
                        builder.setLength(0);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        Buffer buffer=new Buffer(10);
        new Producent(buffer).start();
        new Consumer(buffer).start();
    }
}