public class Guardsman {
    private int activeReaders,writers,waitingReaders;
    private int sharedData;
    private TreasureRoom treasureRoom;

    public Guardsman(TreasureRoom treasureRoom){
        this.treasureRoom = treasureRoom;
        activeReaders=writers=waitingReaders=0;
        sharedData= this.treasureRoom.balance;
    }
    public synchronized void acquireRead(){
        waitingReaders++;
        while (writers>0){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        waitingReaders--;
        activeReaders++;
    }
    public synchronized void releaseRead(){
        activeReaders--;
        if(activeReaders==0){
            notifyAll();
        }
    }
    public synchronized void acquireWrite(){
        while (activeReaders>0||writers>0||waitingReaders>0){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        writers++;
    }
    public synchronized void releaseWrite(){
        writers--;
        notifyAll();
    }
    public void doWrite(Mine valuable){
        treasureRoom.add(valuable);
    }
    public int doRead(){
        return treasureRoom.showBalance();
    }
    public int obtain(int i){
        return treasureRoom.obtain(i);
    }
    public void payParty(int price){
        treasureRoom.payParty(price);
    }
    public void remove(int i){
        treasureRoom.remove(i);
    }
}
