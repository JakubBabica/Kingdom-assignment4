public class Accountant implements Runnable{
    private Guardsman sharedResourceController;
    private String name;
    private TreasureRoom treasureRoom;

    public Accountant(Guardsman sharedResourceController, String name){
        this.name=name;
        this.sharedResourceController=sharedResourceController;
    }

    @Override
    public void run() {
        while (true){
            sharedResourceController.acquireRead();
            int i = sharedResourceController.doRead();
            System.out.println("accountant - BALANCE: "+i);
            sharedResourceController.releaseRead();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
