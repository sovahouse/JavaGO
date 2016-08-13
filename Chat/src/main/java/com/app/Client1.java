package com.app;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client1{

    public static void main(String[] args) throws IOException {
        String input;
        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        DataOutputStream responseToTheServer = new DataOutputStream(socket.getOutputStream());
        DataInputStream responseFromTheServer = new DataInputStream(socket.getInputStream());
        BufferedReader bufferedReader;

        while (true) {
//            responseToTheServer = new DataOutputStream(socket.getOutputStream());
//            responseFromTheServer = new DataInputStream(socket.getInputStream());

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();

            responseToTheServer.writeBytes(input + "\n");
            if(input.equals("Exit")) break;

            System.out.println("Client 1: " + responseFromTheServer.readLine());
        }
        responseToTheServer.close();
        responseFromTheServer.close();
        socket.close();
    }
}
