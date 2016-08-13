package com.app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket =new Socket(InetAddress.getLocalHost(), 3001);
        PrintStream output = new PrintStream(socket.getOutputStream());
        output.write(("Text" + System.currentTimeMillis()).getBytes());
        output.flush();
        output.close();
    }

}
