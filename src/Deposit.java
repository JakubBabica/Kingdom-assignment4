import java.util.LinkedList;
import java.util.Queue;

public class Deposit {
    private Queue<Mine> queue;
    private int capacity;

    public Deposit(int capacity) {
        queue=new LinkedList<>();
        this.capacity = capacity;
    }
    public synchronized void add(Mine mine){
        while(queue.size()>=capacity){
            try{
                System.out.println("queue was full");
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        queue.add(mine);
        notifyAll();
    }
    public synchronized Mine retrieve(){
        while (queue.isEmpty()){
            try{
                System.out.println("queue was empty");
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Mine mine = queue.poll();
        notifyAll();
        return mine;
    }
}
