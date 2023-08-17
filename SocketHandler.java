import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class SocketHandler extends Thread{
    private Socket socket;
    SocketHandler(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            while(!line.isEmpty()){
                System.out.println(line);
                line = br.readLine();
            }
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/HTML");
            pw.println();
            pw.println("<html><body>");
            pw.println(LocalDateTime.now());
            pw.println("</body></html>");
            pw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                socket.close(); // doing this because if we donot do it then browser will keep loading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
}
