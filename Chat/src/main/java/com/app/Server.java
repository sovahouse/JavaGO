package com.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3001, 50, InetAddress.getLocalHost());
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());

        byte[] data = new byte[in.available()];
        in.read(data);
        //System.out.println("Server:" + new String(data));
        socket.close();
    }
}
