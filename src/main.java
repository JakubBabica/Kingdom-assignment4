public class main {
    public static void main(String[] args) {
        TreasureRoom treasureRoom = new TreasureRoom();
        Guardsman gr = new Guardsman(treasureRoom);

        Deposit queue = new Deposit(5);
        Miner Peter = new Miner(queue, 1);
        Miner Vlado = new Miner(queue, 2);
        Miner Stefan = new Miner(queue, 3);
        Miner Miro = new Miner(queue, 4);
        Miner Ivan = new Miner(queue, 4);
        Transporter Jozef = new Transporter(queue, 1, gr);
        Transporter Filip = new Transporter(queue, 2, gr);
        Accountant Mike = new Accountant(gr,"Mike");
        King Julian = new King(gr,treasureRoom);

        Thread thread = new Thread(Peter);
        Thread thread2 = new Thread(Jozef);
        Thread thread3 = new Thread(Vlado);
        Thread thread9 = new Thread(Mike);
        Thread thread10 = new Thread(Filip);
        Thread thread11 = new Thread(Stefan);
        Thread thread12 = new Thread(Miro);
        Thread thread13 = new Thread(Ivan);
        Thread thread420 = new Thread(Julian);


        thread.start();
        thread3.start();
        thread9.start();
        thread2.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread420.start();

    }
}
