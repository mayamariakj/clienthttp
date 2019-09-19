package com.clienthttpTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class WwwClientResponse {
    private Socket socket;
    private String statusLine;

    public WwwClientResponse(Socket socket) {
        this.socket = socket;
    }

    public void invoke() throws IOException {
        InputStream input = socket.getInputStream();
        int c;

        StringBuilder statusLine = new StringBuilder();
        while ((c = input.read()) != -1 && c != '\r') {
            statusLine.append((char)c);
        }
        this.statusLine = statusLine.toString();

        while ((c = input.read()) != -1){
            System.out.print((char) c);
        }
    }

    public int getStatusCode() {
        return Integer.parseInt(statusLine.split(" ")[1]);
    }
}
