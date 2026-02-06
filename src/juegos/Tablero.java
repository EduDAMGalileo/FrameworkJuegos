
package juegos;

import java.util.Arrays;

public class Tablero {
	private char[][] celdas;
	private int dimension;

	public Tablero() {
		this.dimension = 3;
		this.celdas = new char[dimension][dimension];
		inicializar();
	}

	private void inicializar() {
		for (int i = 0; i < dimension; i++) {
			Arrays.fill(celdas[i], '-');
		}
	}

	public void mostrar() {
		System.out.println("\n Tablero actual \n-----------------");
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(celdas[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public boolean colocarFicha(int f, int c, char simbolo) {
		if (f < 0 || f >= dimension || c < 0 || c >= dimension) {
			System.out.println("Error: Coordenadas fuera de rango.");
			return false;
		}
		if (celdas[f][c] != '-') {
			System.out.println("Error: Casilla ocupada.");
			return false;
		}
		celdas[f][c] = simbolo;
		return true;
	}

	public boolean hayEmpate() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (celdas[i][j] == '-') return false;
            }
        }
        return true;
    }
	
	public boolean hayGanador() {
		return comprobarFilas() || 
				comprobarColumnas() || 
				comprobarDiagonalPrincipal() || 
				comprobarDiagonalInversa();
	}

	// --- MÉTODOS PRIVADOS ---

	private boolean comprobarFilas() {
		for (int i = 0; i < dimension; i++) {
			// Cogemos el primer carácter de la fila
			char primero = celdas[i][0];
			// Si no es un hueco vacío, comprobamos si el resto de la fila es igual
			if (primero != '-' && todoIgualEnFila(i, primero)) {
				return true;
			}
		}
		return false;
	}

	private boolean todoIgualEnFila(int f, char patron) {
		// Empezamos en 1 porque el 0 ya lo tenemos
		for (int c = 1; c < dimension; c++) { 
			if (celdas[f][c] != patron) return false;
		}
		return true;
	}

	private boolean comprobarColumnas() {
		for (int j = 0; j < dimension; j++) {
			char primero = celdas[0][j];
			if (primero != '-' && todoIgualEnColumna(j, primero)) {
				return true;
			}
		}
		return false;
	}

	private boolean todoIgualEnColumna(int c, char patron) {
		for (int f = 1; f < dimension; f++) {
			if (celdas[f][c] != patron) return false;
		}
		return true;
	}

	private boolean comprobarDiagonalPrincipal() {
		char primero = celdas[0][0];
		if (primero == '-') {
			return false;
		}

		for (int i = 1; i < dimension; i++) {
			if (celdas[i][i] != primero) {
				return false;
			}
		}
		return true;
	}

	private boolean comprobarDiagonalInversa() {
		char primero = celdas[0][dimension - 1];
		if (primero == '-') return false;

		for (int i = 1; i < dimension; i++) {
			if (celdas[i][dimension - 1 - i] != primero) {
				return false;
			}
		}
		return true;
	}
}