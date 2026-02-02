package es.etg.dam.psp;

public class ContadorEuros {

    private int totalEuros = 0;

    public synchronized int sumarOperacion() {
        totalEuros++;
        return totalEuros;
    }

    public int getTotalEuros() {
        return totalEuros;
    }
}

