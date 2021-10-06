import java.io.*;
import java.net.*;

public class TCPServerEchoThread extends Thread {
    private Socket socket;

    public TCPServerEchoThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {
//        System.setProperty("line.separator", "\r\n"); // Mac users only
        String thread_ID = Long.toString(currentThread().getId());
        System.out.println("THREAD " + thread_ID + " entering");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("s20946");
            out.println("336089");

            String n = null;
            String x = null;


            n = in.readLine();
            x = in.readLine();


            System.out.println(n + " : " + x);

            out.println(n + x);


        } catch (IOException e1) {
            System.out.println("No I/O");
            // do nothing
        }

        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("No I/O");
            // do nothing
        }
        System.out.println("THREAD " + thread_ID + " exiting");
    }
}
