// 6 y 7 de enero
// Clase principal Main para ejecutar el juego
package Clases;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("*******************************************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("*******************************************************");

        // Crear mapa
        Mapa mapa = new Mapa();

        // Nuestro jugador
        System.out.print("Introduce el nombre del explorador: ");
        String nombreExplorador = teclado.nextLine();
        Explorador explorador = new Explorador(nombreExplorador, mapa);

        // Para crear los enemigos. No hice la clase Enemigo inteligente porque al principio la hice y me salio mal 
        // asi que para que me saliese bien lo tuve que hacer desde el main
        Enemigo[] enemigos = new Enemigo[3];
        for (int i = 0; i < enemigos.length; i++) {
            enemigos[i] = new Enemigo("Enemigo" + (i + 1), mapa);
        }

        // Ciclo del juego
        boolean juegoActivo = true;
        while (juegoActivo) {
            mapa.mostrarMapa();

            System.out.println("\nUsa las teclas para moverte:");
            System.out.println("W: Arriba");
            System.out.println("S: Abajo");
            System.out.println("A: Izquierda");
            System.out.println("D: Derecha");
            System.out.print("Tu movimiento: ");

            char opcion = teclado.next().toUpperCase().charAt(0); // con el upperCase siempre se obtendrá un único carácter en mayúsculas como entrada, da igual que lo pongas en minusculas
            int direccion;
            switch (opcion) {
                case 'W': // para estos casos el case es de mas facil de usar que un if
                    direccion = 1; // Arriba
                    break;
                case 'S':
                    direccion = 2; // Abajo
                    break;
                case 'D':
                    direccion = 3; // Derecha
                    break;
                case 'A':
                    direccion = 4; // Izquierda
                    break;
                default:
                    direccion = 0; // Movimiento incorrecto
                    break;
            }

            if (direccion > 0) {
                explorador.mover(direccion);
            } else {
                System.out.println("el moviemento no es válido.");
            }


            // Movimiento de los enemigos
            for (Enemigo enemigo : enemigos) {
                enemigo.mover();
            }

           // estado de jugo
            if (mapa.exploradorEnTesoro()) {
                System.out.println("¡Felicidades! Has encontrado el tesoro y ganado el juego.");
                juegoActivo = false;
            } else if (mapa.exploradorEnPeligro()) {
                System.out.println("¡Has muerto! Un enemigo o una trampa te ha matado.");
                juegoActivo = false;
            }
        }

        System.out.println("Gracias por jugar.");
        teclado.close(); // cerramos el scnanner
    } 
}
