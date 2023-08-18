import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerContainer {
    public static int port;
    ServerContainer(int dport){
        ServerContainer.port = dport;
    }

    public void start() throws  IOException{
        ServerSocket ss = new ServerSocket(port);
        while(true){
            Socket s = ss.accept();
            Thread socketHandler = new SocketHandler(s);
            socketHandler.start(); // this refers to start method of thread
        }
    }
    public static void main(String[] args) throws IOException {
        ServerContainer sc = new ServerContainer(9999);
        sc.start();
    }
}
