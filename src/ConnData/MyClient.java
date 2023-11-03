package ConnData;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.1.12", 9999);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server says: " + str2);
        }

        dout.close();
        s.close();
    }

    public void setTitle(String s) {
    }

    public void setVisible(boolean b) {
    }
}
