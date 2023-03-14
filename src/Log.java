import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.time.LocalDateTime;

public class Log {
    private static Log instance;

    private Log(){

    }
    public static Log getInstance(){
        if (instance==null){
            instance = new Log();
        }
        return instance;
    }
    public void writeToFile(String info) {
        String filename = "log.txt";
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(filename, true));
            out.write(info+"\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
