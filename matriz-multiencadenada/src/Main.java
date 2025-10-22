import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int opcion = 0;
        Interfaz matriz = new Interfaz();

        do {
            menu();
            System.out.print("Ingrese una opcion: ");
            opcion = keyboard.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese tamaño de la matriz: ");
                int f = keyboard.nextInt();
                System.out.println("Muy bien hecho, matriz creada");
                ///matriz.crearMatriz(f);
            } else if (opcion == 2) {
                ///matriz.mostrarMatriz();
            } else if (opcion == 3) {
                ///matriz.mostrarDiagonalPrincipal();
            } else if (opcion == 4) {
               /// matriz.mostrarDiagonalSecundaria();
            } else if (opcion == 5) {
                ///matriz.mostrarTriangularInferior();
            } else
                if (opcion == 6) {
               /// matriz.mostrarTriangularSuperior();
            } else if (opcion == 7) {
                System.out.println(" Salir del programa");
                System.out.println("Programa finalizado");
                break;
            } else {
                System.out.println(" Opcion invalida");
            }

        } while (true);
        keyboard.close();
    }

    public static void menu() {
        System.out.println("\n================== MENÚ MATRICES ==================");
        System.out.println("1 Crear matriz");
        System.out.println("2 Mostrar matriz");
        System.out.println("3 Mostrear diagonal principal");
        System.out.println("4 Mostrar diagonal secundaria");
        System.out.println("5 Mostrar triangular inferior");
        System.out.println("6 Mostrar triangular superior");
        System.out.println("7 Salir");
    }
}
