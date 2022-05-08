import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Blockchain blockchain = new Blockchain();
    public static Blockchain BLOCKCHAIN;

    public static void main(String[] args) {
       Server.getInstance().SocketServer(4444);
       Server.getInstance().SocketClient("localhost", 5555);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
        }

        blockchain.addTransaction(new Transaction("myCoin->Ahmad->50"));
        blockchain.addTransaction(new Transaction("Ahmad->Mohammed->50"));
        blockchain.addTransaction(new Transaction("Ahmad->Mousa->50"));
        blockchain.mine();
        blockchain.addTransaction(new Transaction("myCoin->Ahmad->40"));
        blockchain.addTransaction(new Transaction("Mohammed->Mousa->30"));
        blockchain.mine();

    }

    private static void blocksExplorer() {
        System.out.println(blockchain);
    }

    private static void storeBlockChain() {
        try {
            FileWriter myWriter = new FileWriter("Blockchain.txt");
            myWriter.write(blockchain.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

