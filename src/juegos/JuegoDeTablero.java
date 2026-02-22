package juegos;

import java.util.Scanner;

public class JuegoDeTablero {
    protected Tablero tablero;
    protected Jugador j1, j2;
    protected Jugador turnoActual;
    protected Scanner sc; 

    public JuegoDeTablero(String n1, char s1, String n2, char s2) {
        this.tablero = new Tablero();
        this.j1 = new Jugador(n1, s1);
        this.j2 = new Jugador(n2, s2);
        this.turnoActual = j1;
        this.sc = new Scanner(System.in);
    }

    protected void mostrarTurno() {
        System.out.println("\n---------------------------------");
        System.out.println(">>> Turno de " + turnoActual.getNombre());
    }

    protected void realizarJugadaManualmente() {
        boolean fichaColocada = false;
        int max = tablero.getDimension(); 
        while (!fichaColocada) {
            System.out.print("Fila (1-" + max + "): ");
            int f = sc.nextInt() - 1;
            System.out.print("Columna (1-" + max + "): ");
            int c = sc.nextInt() - 1;
            
            // Delegamos la validación en el objeto tablero, igual que antes
            fichaColocada = tablero.colocarFicha(f, c, turnoActual.getSimbolo());
        }
    }

    protected void cambiarTurno() {
        this.turnoActual = (turnoActual == j1) ? j2 : j1;
    }
}