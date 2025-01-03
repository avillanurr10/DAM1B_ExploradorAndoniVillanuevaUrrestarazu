// 2 de enero
package Clases;

import java.util.Random;

public class Explorador {
    private String nombre;
    private Posicion posicionActual;

    // Constantes para el movimiento
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public static final int IZQUIERDA = 4;

    public Explorador(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        int filaAleatoria = random.nextInt(6); // Filas entre 0 y 5
        this.posicionActual = new Posicion(filaAleatoria, 0); // Siempre en la primera columna
    }

    public void moverse(int direccion) {
        int nuevaFila = posicionActual.getCoordenadaFila();
        int nuevaCol = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case ARRIBA: {
                if (nuevaFila > 0) nuevaFila--;
                break;
            }
            case ABAJO: {
                if (nuevaFila < 5) nuevaFila++;
                break;
            }
            case DERECHA: {
                if (nuevaCol < 19) nuevaCol++;
                break;
            }
            case IZQUIERDA: {
                if (nuevaCol > 0) nuevaCol--;
                break;
            }
            default: {
                System.out.println("Dirección no válida");
                break;
            }
        }

        posicionActual.setCoordenadaFila(nuevaFila);
        posicionActual.setCoordenadaCol(nuevaCol);
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion nuevaPosicion) {
        this.posicionActual = nuevaPosicion;
    }
}
