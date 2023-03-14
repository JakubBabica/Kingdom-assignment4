public class Miner implements Runnable{
    private Mine valuable;
    private Deposit queue;
    private String name;
    private Log log;

    public Miner(Deposit queue, int id){
        this.queue=queue;
        name="Miner "+id;
        log=Log.getInstance();
    }

    public  void run() {
        try{
            while (true){
                Thread.sleep(1000);
                valuable=Mine.randomValuable();
                queue.add(valuable);
                log.writeToFile(name+" added "+valuable);
                System.out.println(name+" added "+valuable);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
