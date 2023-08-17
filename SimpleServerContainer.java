import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

// a simple server container which can only handel one request at a time.
// it displays current date and time

public class SimpleServerContainer{
    public static int port;
    SimpleServerContainer(int dport){
        SimpleServerContainer.port = dport;
    }
    public void start() throws  IOException{
        try(ServerSocket ss = new ServerSocket(port)){
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = br.readLine();
            while(!line.isEmpty()){
                System.out.println(line);
                line = br.readLine();
            }
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/HTML");
            pw.println();
            pw.println("<html><body>");
            pw.println(LocalDateTime.now());
            pw.println("</body></html>");
            pw.flush();
        }
    }

    public static void main(String[] args) throws IOException{
        SimpleServerContainer sc = new SimpleServerContainer(9999);
        sc.start();
    }
}