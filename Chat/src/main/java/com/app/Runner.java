package com.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Map<Integer, String> messages = new HashMap<Integer, String>();
        List<Integer> activeConnections = new ArrayList<Integer>();
        System.out.println("Listening");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            new Thread(new MultiThreadServer(socket, messages, activeConnections)).start();
        }
    }
}
