import java.util.concurrent.ThreadLocalRandom;

public class King implements Runnable{
    private Guardsman sharedResourceController;
    private String name;
    private TreasureRoom treasureRoom;
    private Log log;
    private int min=50;
    private int max=150;


    public King(Guardsman sharedResourceController, TreasureRoom tr){
        this.sharedResourceController=sharedResourceController;
        name="King";
        this.treasureRoom=tr;
        log=Log.getInstance();
    }

    @Override
    public void run() {
        try{
            while(true){
                sharedResourceController.acquireWrite();
                log.writeToFile(name+"got the write access");
                System.out.println(name+"got the write access");
                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                int test=0;
                int i=0;
                if(randomNum<sharedResourceController.doRead()){
                    sharedResourceController.payParty(randomNum);
                    while (randomNum>=test) {
                        test=test+sharedResourceController.obtain(i);
                        sharedResourceController.remove(i);
                    }
                log.writeToFile("king threw a party of size " + test+" coins"+" remaining balance:"+sharedResourceController.doRead());
                System.out.println("king threw a party of size " + test+" coins"+" remaining balance:"+sharedResourceController.doRead());
                }
                sharedResourceController.releaseWrite();
                log.writeToFile(name+"released write access");
                System.out.println(name+"released write access");
                    Thread.sleep(5000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
