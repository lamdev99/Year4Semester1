/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lamit
 */
class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
                str = din.readUTF(); //doc du lieu vao
                System.out.println("client " + str);
                str2 = br.readLine();
                dout.writeUTF(str2); //ghi du lieu
                dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
