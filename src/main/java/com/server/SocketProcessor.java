package com.server;

import java.io.IOException;
import java.net.Socket;

public class SocketProcessor implements Runnable{
    private final Socket clientSocket;
    private final SocketIOHandler socketIOHandler;
    SocketProcessor(Socket clientSocket){
        this.clientSocket =  clientSocket;
        this.socketIOHandler = new SocketIOHandler(clientSocket);
    }

    @Override
    public void run() {
       //add your request processing functionality in the run method
    }
}
