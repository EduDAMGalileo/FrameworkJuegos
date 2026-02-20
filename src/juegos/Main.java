package juegos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== BIENVENIDO A LA CONSOLA DE JUEGOS ===");
        System.out.println("1. Tres en Raya Clásico");
        System.out.println("2. Tres en Raya Miseria (El que hace 3, pierde)");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        
        if (opcion == 1) {
            TresEnRayaOriginal partida = new TresEnRayaOriginal("Eduardo", 'X', "Abraham", 'O');
            partida.iniciar();
        } else if (opcion == 2) {
        	TresEnRayaMiseria partida = new TresEnRayaMiseria("Eduardo", 'X', "Abraham", 'O');
            partida.iniciar();
        } else {
            System.out.println("Opción no válida.");
        }
        sc.close();
    }
}