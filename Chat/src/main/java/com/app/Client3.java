package com.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class Client3 {


    public static void main(String[] args) throws IOException, InterruptedException {
        final Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("fQQQQlpelfpwerrewwre1111");
       // out.flush();
       //// socket.close();
       // Thread.sleep(Long.MAX_VALUE);
        Thread t = new Thread(){

            public void run(){

                while(true){
                    try {
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        String res = in.readUTF();
                        System.out.println(res);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }

        };
        t.start();

    }
}
