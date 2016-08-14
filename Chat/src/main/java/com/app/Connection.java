package com.app;

import java.io.DataInputStream;
import java.net.Socket;

public class Connection  implements Runnable{
    private Socket socket;
    private MultiThreadServer multiThreadServer;

    public Connection(Socket socket, MultiThreadServer multiThreadServer) {
        this.socket = socket;
        this.multiThreadServer = multiThreadServer;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while(true){
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String str = in.readUTF();
                multiThreadServer.sendMassege(str);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
