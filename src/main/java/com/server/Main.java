package com.server;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // initialise server using this object and listen to port
        Server server = new Server(1765);
        server.listen();
    }
}