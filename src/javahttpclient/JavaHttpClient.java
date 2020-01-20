package javahttpclient;
import java.net.*;
import java.io.*;
/**
 *
 * @author Felix
 */
public class JavaHttpClient {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaHttpClient client = new JavaHttpClient();
        client.GetExample();
    }
    
    public JavaHttpClient() {}
    
    public void GetExample() {
        try {
            socket = new Socket("httpbin.org", 80);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            
            String request = "GET /status/418 HTTP/1.0\r\n\r\n";
            
            out.write(request.getBytes());
            out.flush();
            
            StringBuilder response = new StringBuilder();
            
            int data = in.read();
            
            while(data != -1) {
                response.append((char)data);
                data = in.read();
            }
            
            System.out.println(response);
            socket.close();
            
            
        } catch(UnknownHostException e) {
            System.out.println(e);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    
}
