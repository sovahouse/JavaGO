package com.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class MultiThreadServer  {
    //private Socket socket;
    private static List<Connection> activeConnections = new ArrayList<Connection>();
    //private MultiThreadServer(Socket socket) {
     //   this.socket = socket;
    //s}

    public MultiThreadServer() {

    }

    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Listening");
        MultiThreadServer server = new MultiThreadServer();
        while (true) {
            Socket socket = serverSocket.accept();
            activeConnections.add(new Connection(socket, server));
            System.out.println("Connected");
           // new Thread(new MultiThreadServer(socket)).start();
        }
    }


    public synchronized void sendMassege(String massege) throws IOException {
        System.out.println("Send:"+massege);
        for (Connection c:activeConnections) {
            DataOutputStream output = new DataOutputStream(c.getSocket().getOutputStream());
            output.writeUTF(massege);
        }
    }
}