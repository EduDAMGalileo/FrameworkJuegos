package juegos;

public class TresEnRayaTresFichas extends JuegoDeTablero{

	public TresEnRayaTresFichas(String n1, char s1, String n2, char s2) {
		super(n1, s1, n2, s2);
	}


	public void iniciar() {
        // --- FASE 1: COLOCACIÓN ---
        // Al ser 3 fichas por jugador, sabemos que son exactamente 6 turnos.
        System.out.println("\n=== FASE DE COLOCACIÓN (3 fichas cada uno) ===");
        for (int i = 0; i < 6; i++) {
            tablero.mostrar();
            mostrarTurno();
            
            // Reutilizamos el método del padre: aquí solo queremos "poner" fichas
            realizarJugadaManualmente(); 
            
            // Verificamos por si alguien hace 3 en raya antes de terminar de colocar, puede ocurrir en los turnos 5 o 6
            if (tablero.hayGanador()) { 
                anunciarGanador(turnoActual);
                return; // Cortamos la ejecución
            }

            cambiarTurno();
        }

        // --- FASE 2: MOVIMIENTO ---
        System.out.println("\n=== FASE DE MOVIMIENTO ===");
        boolean finPartida = false;
        while (!finPartida) {
            tablero.mostrar();
            mostrarTurno();
            
            moverFichaManualmente(); 

            if (tablero.hayGanador()) {
                anunciarGanador(turnoActual);
                finPartida = true;
            } else {
                cambiarTurno();
            }
        }
        
    }
	
    private void moverFichaManualmente() {
        boolean exito = false;
        // Evitamos los números mágicos preguntando al tablero su tamaño
        int max = tablero.getDimension(); 

        while (!exito) {
            System.out.println("Selecciona una de tus fichas para moverla:");
            System.out.print("Fila origen (1-" + max + "): ");
            int fo = sc.nextInt() - 1;
            System.out.print("Columna origen (1-" + max + "): ");
            int co = sc.nextInt() - 1;

            //¿Realmente hay una ficha suya en esa coordenada?
            if (tablero.getFicha(fo, co) == turnoActual.getSimbolo()) {
                
                System.out.println("¿A dónde la quieres mover?");
                System.out.print("Fila destino (1-" + max + "): ");
                int fd = sc.nextInt() - 1;
                System.out.print("Columna destino (1-" + max + "): ");
                int cd = sc.nextInt() - 1;

                // Intentamos colocarla en el destino. 
                if (tablero.colocarFicha(fd, cd, turnoActual.getSimbolo())) {
                    // Si el tablero aceptó el destino, borramos la ficha de su lugar original
                    tablero.vaciarCasilla(fo, co); 
                    exito = true;
                }
            } else {
                System.out.println("Error: Esa casilla no contiene una ficha tuya.");
            }
        }
    }


}
