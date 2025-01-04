// 3 de enero con edicion 4
package Clases;
// Clase Enemigo que representa a los enemigos del juego
public class Enemigo {
    private String nombre;
    private Posicion posicion;
    private Mapa mapa;

    public Enemigo(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.posicion = mapa.inicializarEnemigo();
    }

    public void mover() {
        int direccion = new java.util.Random().nextInt(4) + 1;
        mapa.moverEntidad(posicion, direccion, 'E');
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}
