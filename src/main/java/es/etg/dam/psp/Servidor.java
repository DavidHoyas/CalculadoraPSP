package es.etg.dam.psp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PUERTO = 5000;
    public static final String MSG_ESCUCHA = "Servidor escuchando...";

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println(MSG_ESCUCHA);

            while (true) {
                Socket socket = serverSocket.accept();
                
                Thread hilo = new Thread(new GestorClientes(socket));
                hilo.start();
            }
        }
    }
}


