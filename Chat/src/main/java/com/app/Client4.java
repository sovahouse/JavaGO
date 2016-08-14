package com.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client4 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        while(true){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String res=in.readUTF();
            System.out.println(res);

        }
    }
}
