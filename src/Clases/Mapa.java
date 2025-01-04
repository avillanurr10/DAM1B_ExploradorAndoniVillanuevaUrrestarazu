// 3 y 4 de enero. he tenido que crear algun metodo mas ya que no me salia bien el menu de ejecución
package Clases;
// Clase Mapa que representa el tablero del juego
public class Mapa {
    private char[][] tablero;
    private Posicion tesoro;

    public Mapa() {
        tablero = new char[6][20];
        inicializarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Colocar trampas
        int trampasColocadas = 0;
        while (trampasColocadas < 3) {
            int fila = (int) (Math.random() * 6);
            int columna = (int) (Math.random() * 20);
            if (tablero[fila][columna] == ' ') {
                tablero[fila][columna] = 'T';
                trampasColocadas++;
            }
        }

        // Colocar tesoro
        int fila, columna;
        do {
            fila = (int) (Math.random() * 6);
            columna = (int) (Math.random() * 20);
        } while (tablero[fila][columna] != ' ');
        tesoro = new Posicion(fila, columna);
    }

    public Posicion inicializarExplorador() {
        java.util.Random random = new java.util.Random();
        int fila = random.nextInt(6);
        tablero[fila][0] = 'J';
        return new Posicion(fila, 0);
    }

    public Posicion inicializarEnemigo() {
        java.util.Random random = new java.util.Random();
        int fila, columna;
        do {
            fila = random.nextInt(6);
            columna = random.nextInt(20);
        } while (tablero[fila][columna] != ' ');
        tablero[fila][columna] = 'E';
        return new Posicion(fila, columna);
    }

    public void mostrarMapa() {
        for (char[] fila : tablero) {
            for (char c : fila) {
                switch (c) {
                    case 'J':
                        System.out.print("\u001B[34mJ \u001B[0m"); // Azul para el jugador , no se poruqe no se ve tan azul
                        break;
                    case 'E':
                        System.out.print("\u001B[31mE \u001B[0m"); // Rojo para los enemigos
                        break;
                    case 'T':
                        System.out.print("\u001B[33mT \u001B[0m"); // Amarillo para trampas
                        break;
                    default:
                        System.out.print("  "); // Espacio vacío
                        break;
                }
            }
            System.out.println();
        }
    }

    public void moverEntidad(Posicion posicion, int direccion, char entidad) {
        int nuevaFila = posicion.getCoordenadaFila();
        int nuevaColumna = posicion.getCoordenadaCol();

        switch (direccion) {
            case 1:
                nuevaFila--; // Mover hacia arriba (disminuye la fila)
                break;
            case 2:
                nuevaFila++; // Mover hacia abajo (aumenta la fila)
                break;
            case 3:
                nuevaColumna++; // Mover hacia la derecha (aumenta la columna)
                break;
            case 4:
                nuevaColumna--; // Mover hacia la izquierda (disminuye la columna)
                break;
        }

        if (esMovimientoValido(nuevaFila, nuevaColumna)) {
            tablero[posicion.getCoordenadaFila()][posicion.getCoordenadaCol()] = ' ';
            tablero[nuevaFila][nuevaColumna] = entidad;
            posicion.setCoordenadaFila(nuevaFila);
            posicion.setCoordenadaCol(nuevaColumna);
        }
    }

    public boolean exploradorEnTesoro() {
        return tablero[tesoro.getCoordenadaFila()   ][tesoro.getCoordenadaCol()] == 'J';
    }

    public boolean exploradorEnPeligro() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'E' && tablero[tesoro.getCoordenadaFila()][tesoro.getCoordenadaCol()] == 'E') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean esMovimientoValido(int fila, int columna) {
        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public Posicion getTesoro() {
        return tesoro;
    }

    public void setTesoro(Posicion tesoro) {
        this.tesoro = tesoro;
    }
}