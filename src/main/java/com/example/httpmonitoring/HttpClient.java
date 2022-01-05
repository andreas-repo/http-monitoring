package com.example.httpmonitoring;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpClient {
    public HttpClient() throws Exception {
        final Socket so = new Socket("localhost", 8085);
        final OutputStream os = so.getOutputStream();

        final String request = "GET http://localhost:8085/onlineshop-web/ HTTP/1.1\r\n";
        os.write(request.getBytes());

        final  String header = "Host: localhost\r\n\r\n";
        os.write(header.getBytes());

        final InputStream in = so.getInputStream();
        final byte[] responseBytes = new byte[1];

        while((in.read(responseBytes)) != -1) {
            System.out.write(responseBytes, 0, 1);
        }

        os.close();
        in.close();
        so.close();
    }

    public static void main(String[] args) throws Exception {
        new HttpClient();
    }
}
