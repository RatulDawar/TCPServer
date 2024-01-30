package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    int port;
    public Server(int port){
        this.port = port;
    }
    public void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(this.port);
        ExecutorService executorService = Executors.newCachedThreadPool();

        // handling multiple requests using infinite while loop
        while(true) {
            Socket clientSocket = serverSocket.accept();
            // processing requests in different threads
            executorService.submit(new SocketProcessor(clientSocket));

        }

    }
}
