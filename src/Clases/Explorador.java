// 2 de enero y algunas ediciones el 4
package Clases;
// Clase Explorador que representa al jugador
public class Explorador {
    private String nombre;
    private Posicion posicion;
    private Mapa mapa;

    public Explorador(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.posicion = mapa.inicializarExplorador();
    }

    public void mover(int direccion) {
        mapa.moverEntidad(posicion, direccion, 'J');
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
