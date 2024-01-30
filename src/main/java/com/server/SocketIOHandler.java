package com.server;

import com.configurables.Configurable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


// reads input and writes output to TCP connection
public class SocketIOHandler {
    private final Socket clientSocket;
    // confi


    SocketIOHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public String read() throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        byte[] buffer = new byte[Configurable.MAX_REQUEST_SIZE_IN_BYTES];
        int bytesRead = inputStream.read(buffer);
        return  bytesRead != - 1 ? new String(buffer,0,bytesRead) : "";
    }

    public void write(String response) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(response.getBytes(StandardCharsets.UTF_8));
    }

}
