package juegos;

public class TresEnRayaOriginal extends JuegoDeTablero {
    
    public TresEnRayaOriginal (String n1, char s1, String n2, char s2) {
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