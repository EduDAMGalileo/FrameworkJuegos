package juegos;


import java.util.Scanner;

public class TresEnRayaMiseria {
    private Tablero tablero;
    private Jugador j1, j2;
    private Jugador turnoActual;

    public TresEnRayaMiseria(String n1, char s1, String n2, char s2) {
        this.tablero = new Tablero();
        this.j1 = new Jugador(n1, s1);
        this.j2 = new Jugador(n2, s2);
        this.turnoActual = j1;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        boolean finPartida = false;

        while (!finPartida) {
            tablero.mostrar();
            System.out.println("\n Turno de " + turnoActual.getNombre() + " (" + turnoActual.getSimbolo() + ")");
            
            // Bucle para asegurar que el jugador pone una ficha válida
            boolean fichaColocada = false;
            while (!fichaColocada) {
                System.out.print("Fila (1-3): ");
                int f = sc.nextInt() - 1;
                System.out.print("Columna (1-3): ");
                int c = sc.nextInt() - 1;
                
                fichaColocada = tablero.colocarFicha(f, c, turnoActual.getSimbolo());
            }

            // Tras colocar ficha, comprobamos a ver si hay ganador
            if (tablero.hayGanador()) {
                tablero.mostrar();
                System.out.println("\n ¡ATENCIÓN! " + turnoActual.getNombre() + " ha formado una línea.");
                System.out.println("HAS PERDIDO. La victoria es para el rival.");
                finPartida = true;
            } else if (tablero.hayEmpate()) {
                tablero.mostrar();
                System.out.println("\n Empate. No quedan movimientos.");
                finPartida = true;
            } else {
                cambiarTurno();
            }
        }
        sc.close();
    }

    private void cambiarTurno() {
        this.turnoActual = (turnoActual == j1) ? j2 : j1;
    }
}