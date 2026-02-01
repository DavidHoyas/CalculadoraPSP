package es.etg.dam.psp;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static final String HOST = "localhost";
    public static final int PUERTO = 5000;
    public static final String MSG_USO_CORRECTO = "Uso: java Cliente \"num1 operador num2\"";

    public static final int INDEX_OPERACION = 0;

    private Socket socket;

    public Cliente() throws IOException {
        this.socket = new Socket(HOST, PUERTO);
    }

    public String enviarOperacion(String operacion) throws IOException {
        Conexion.enviar(operacion, socket);
        return Conexion.recibir(socket);
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println(MSG_USO_CORRECTO);
            System.exit(1);
        }

        String operacion = args[INDEX_OPERACION];

        try {
            Cliente cliente = new Cliente();
            String resultado = cliente.enviarOperacion(operacion);
            System.out.println(resultado);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



