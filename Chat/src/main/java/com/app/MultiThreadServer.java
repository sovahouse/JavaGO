package com.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class MultiThreadServer implements Runnable {
    private Socket socket;
    private Map<Integer, String> messages = new HashMap<Integer, String>();
    private List<Integer> activeConnections = new ArrayList<Integer>();
    private MultiThreadServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Listening");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            new Thread(new MultiThreadServer(socket)).start();
        }
    }
    public void run() {
        try {
            DataOutputStream responseToTheClient = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputFromTheClient = new DataInputStream(socket.getInputStream());
            String userInput ;
            while (true) {

                userInput = inputFromTheClient.readLine();
                if (userInput.equals("Exit")) break;

                messages.put(socket.getPort(), userInput);
                if(!activeConnections.contains(socket.getPort())) {
                    activeConnections.add(socket.getPort());
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (Integer i:activeConnections) {
                    if(i.equals(socket.getPort())) {
                        continue;
                    }
                    stringBuilder.append(i + ": " +messages.get(i) + "\n");
                }

                responseToTheClient.writeBytes(stringBuilder.toString() + "\n");

            }
            activeConnections.remove(socket.getPort());
            inputFromTheClient.close();
            responseToTheClient.close();
            socket.close();
            System.out.println("Closed");


        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}