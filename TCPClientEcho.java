import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class TCPClientEcho {
    public static void main(String args[]) throws IOException {
//        System.setProperty("line.separator", "\r\n"); // Mac users only

        String server_host_address = "172.21.48.172"; // IP: 127.0.0.1   loop back interface
        int port_on_server = 20009;

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;


        // Open TCP connection
        try {
            socket = new Socket(server_host_address, port_on_server);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Unknown host");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("No I/O");
            System.exit(-1);
        }

        // Communicate
        try {
            out.println("s20946");
            out.println("172.23.129.82:5555");

            String line;
            line = in.readLine();
            if (line != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error during communication");
            System.exit(-1);
        }

        // Close TCP connection
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Cannot close the socket");
            System.exit(-1);
        }
    }
}