package juegos;

public class TresEnRayaMiseria extends JuegoDeTablero {
    
    public TresEnRayaMiseria (String n1, char s1, String n2, char s2) {
        super(n1, s1, n2, s2); 
    }


    public void iniciar() {
        boolean finPartida = false;

        while (!finPartida) {
        	//Cada uno de los turnos
            tablero.mostrar();          
            mostrarTurno();             
            realizarJugadaManualmente(); 

            // El hijo solo se encarga de aplicar su REGLAMENTO
            if (tablero.hayGanador()) {
                tablero.mostrar();
                cambiarTurno();
                System.out.println("\n ¡FELICIDADES! " + turnoActual.getNombre() + " ha ganado.");
                finPartida = true;
            } else if (tablero.hayEmpate()) {
                System.out.println("\n Empate técnico. El tablero está lleno.");
                finPartida = true;
            } else {
                cambiarTurno(); 
            }
        }
    }
}