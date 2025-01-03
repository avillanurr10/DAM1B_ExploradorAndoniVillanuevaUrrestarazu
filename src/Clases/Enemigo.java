//3 de enero
package Clases;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private Posicion posicionActual;

    // Constantes para el movimiento
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public static final int IZQUIERDA = 4;

    public Enemigo(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        int filaAleatoria = random.nextInt(6);
        int columnaAleatoria = random.nextInt(20);
        this.posicionActual = new Posicion(filaAleatoria, columnaAleatoria);
    }

    public void moverseAleatorio(Mapa mapa) { // para diferenciar lo he llamado moverseAleatorio
        Random random = new Random(); // se me hace mas cómodo realizar el random asi
        int direccion = random.nextInt(4) + 1;

        int nuevaFila = posicionActual.getCoordenadaFila();
        int nuevaCol = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case ARRIBA:
                nuevaFila = Math.max(0, nuevaFila - 1);
                break;
            case ABAJO:
                nuevaFila = Math.min(5, nuevaFila + 1);
                break;
            case DERECHA:
                nuevaCol = Math.min(19, nuevaCol + 1);
                break;
            case IZQUIERDA:
                nuevaCol = Math.max(0, nuevaCol - 1);
                break;
        }

        if (mapa.obtenerElemento(nuevaFila, nuevaCol) == ' ') {
            posicionActual.setCoordenadaFila(nuevaFila);
            posicionActual.setCoordenadaCol(nuevaCol);
        }
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public String getNombre() {
        return nombre;
    }
    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }
}
