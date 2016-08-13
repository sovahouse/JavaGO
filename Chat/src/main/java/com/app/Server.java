package com.app;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server;
        String line;
        DataInputStream is;
        PrintStream os;
        Socket clientSocket;

        server = new ServerSocket(9999, 50, InetAddress.getLocalHost());

        clientSocket = server.accept();

        while (true) {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            line = is.readLine();
            os.println(line);
        }

    }
}
