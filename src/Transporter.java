import java.util.concurrent.ThreadLocalRandom;

public class Transporter implements Runnable{
    private Deposit queue;
    private String name;
    private Mine valuable;
    private int min=50;
    private int max=200;
    private Guardsman sharedResourceController;
    private Log log;

    public Transporter(Deposit queue, int id, Guardsman sharedResourceController){
        this.queue=queue;
        name="Transporter "+id;
        this.sharedResourceController=sharedResourceController;
        log=Log.getInstance();
    }
    public void run() {
        try{
            while (true){
                //System.out.println(name+"wants write access");
                sharedResourceController.acquireWrite();
                log.writeToFile(name+"got the write access");
                System.out.println(name+"got the write access");
                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                log.writeToFile("random num: "+randomNum);
                System.out.println("random num: "+randomNum);
                int test=0;
                while(randomNum>=test) {
                    valuable = queue.retrieve();
                    test=test+valuable.getPrice();
                    System.out.println("transporter retrieved "+valuable);
                    sharedResourceController.doWrite(valuable);
                }
                sharedResourceController.releaseWrite();
                log.writeToFile(name+"released write access");
                System.out.println(name+"released write access");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
