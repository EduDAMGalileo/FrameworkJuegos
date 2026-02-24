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
                System.out.println("\n¡ATENCIÓN! " + turnoActual.getNombre() + " ha hecho 3 en raya y PIERDE.");
                // Pasamos el turno al rival para que él sea el ganador
                cambiarTurno(); 
                anunciarGanador(turnoActual); 
                finPartida = true;
            } else if (tablero.hayEmpate()) {
                anunciarEmpate();
                finPartida = true;
            } else {
                cambiarTurno(); 
            }
        }
    }
}