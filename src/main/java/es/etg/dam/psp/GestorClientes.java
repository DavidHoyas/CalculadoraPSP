package es.etg.dam.psp;

import java.io.IOException;
import java.net.Socket;

public class GestorClientes implements Runnable {

    public static final String MSG_FINAL = "Resultado: %s | Coste total: %d euros";
    public static final String SPLIT = " ";

    public static final int INDEX_NUM1 = 0;
    public static final int INDEX_OPERADOR = 1;
    public static final int INDEX_NUM2 = 2;

    private Socket socket;

    public GestorClientes(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Calculadora calculadora = new Calculadora();
            
            String operacion = Conexion.recibir(socket);
            String[] partes = operacion.trim().split(SPLIT);

            String num1 = partes[INDEX_NUM1];
            String operador = partes[INDEX_OPERADOR];
            String num2 = partes[INDEX_NUM2];

            String resultado = calculadora.calcular(num1, operador, num2);

            int costeTotal = calculadora.sumarOperacion();

            String mensajeFinal = String.format(MSG_FINAL, resultado, costeTotal);

            Conexion.enviar(mensajeFinal, socket);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

