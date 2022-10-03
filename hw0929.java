import java.util.*;

class ticket {
    private static int sum = 10000;

    public synchronized static void buy(ticketMachine T, int n) {
        if (sum >= n) {

            int tmp = sum;
            tmp = tmp - n;
            sum = tmp;
            System.out.println(T.getName() + " buys " + n + " tickets, " + sum + " tickets left");
            try{

                Thread.sleep(0,1);//’â‰º1“Þ•b
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
                T.setCounts(T.getCounts()+n);
        } else if (sum <= 0) {

        }
    }

    public static int getSum() {
        return sum;
    }
}

class ticketMachine extends Thread {
    private int counts = 0;

    public ticketMachine(String name) {
        super(name);
    }

    public void run() {
        while (ticket.getSum() > 0) {
            Random r1 = new Random();
            ticket.buy(this, r1.nextInt(4) + 1);
        }


    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}

public class hw0929 {
    public static void main(String args[]) {
        ticketMachine t1 = new ticketMachine("machine1");
        ticketMachine t2 = new ticketMachine("machine2");
        ticketMachine t3 = new ticketMachine("machine3");
        ticketMachine t4 = new ticketMachine("machine4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(t1.getName() + " sells " + t1.getCounts() + " tickets");
        System.out.println(t2.getName() + " sells " + t2.getCounts() + " tickets");
        System.out.println(t3.getName() + " sells " + t3.getCounts() + " tickets");
        System.out.println(t4.getName() + " sells " + t4.getCounts() + " tickets");

    }
}