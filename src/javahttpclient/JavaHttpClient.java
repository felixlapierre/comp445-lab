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
        JavaHttpClient client = new JavaHttpClient();
        client.PostJsonExample();
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
    
    public void GetRedirectExample() {
        try {
            socket = new Socket("google.com", 80);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            
            /**
             * The following request will get a "Permanently Moved" response
             * telling us to redirect to www.google.com.
             */
            String request = "GET / HTTP/1.0\r\n\r\n";

            /**
             * When we get such a response, we should make a request like this
             * instead.
             */
            //String request = "GET / HTTP/1.0\r\nHost: www.google.com\r\n\r\n";
            
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
    
    public void PostUrlEncodedExample() {
        try {
            socket = new Socket("httpbin.org", 80);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            
            /**
             * We are sending this information to an 'echo' server that will just
             * return our form data back to us in the response.
             */
            
            String body = "key1=value1&key2=value2";
            
            String request = "POST /post HTTP/1.0\r\n"
                    + "Content-Type:application/x-www-form-urlencoded\r\n"
                    + "Content-Length: " + body.length() + "\r\n"
                    + "\r\n"
                    + body;
            
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
    
    public void PostMultipartExample() {
        try {
            socket = new Socket("httpbin.org", 80);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            
            /**
             * "limit" can be any string that you choose as delimiter
             */
            
            String body = "--limit\r\n"
                    + "Content-Disposition: form-data; name=\"key1\"\r\n"
                    + "\r\n"
                    + "value1\r\n"
                    + "--limit\r\n"
                    + "Content-Disposition: form-data; name=\"key2\"\r\n"
                    + "\r\n"
                    + "value2\r\n"
                    + "--limit--\r\n";
            
            String request = "POST /post HTTP/1.0\r\n"
                    + "Content-Type:multipart/form-data; boundary=\"limit\"\r\n"
                    + "Content-Length: " + body.length() + "\r\n"
                    + "\r\n"
                    + body;
            
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
    
    public void PostJsonExample() {
        try {
            socket = new Socket("httpbin.org", 80);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            
            String body = "{"
                    + "\"key1\":value1,"
                    + "\"key2\":value2"
                    + "}";
            
            String request = "POST /post?info=info HTTP/1.0\r\n"
                    + "Content-Type:application/json\r\n"
                    + "Content-Length: " + body.length() + "\r\n"
                    + "\r\n"
                    + body;
            
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
