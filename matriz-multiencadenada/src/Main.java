import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int opcion = 0;
        int n = 0;
        NodoM raiz = null;

        do {
            menu();
            System.out.print("Ingrese una opcion: ");
            opcion = keyboard.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese tamaño de la matriz: ");
                n = keyboard.nextInt();
                System.out.println("Ingresa el valor minimo que tendra el valor de los nodos");
                int minRandom = keyboard.nextInt();
                System.out.println("Ingresa el valor maximo que tendra el valor de los nodos");
                int maxRandom = keyboard.nextInt();
                raiz = NodoM.crearMatriz(n, minRandom, maxRandom);
                System.out.println("Matriz creada correctamente:");
                raiz.imprimirMatrizCuadrada(n);

            } else if (opcion == 2) {
                if (raiz != null) raiz.imprimirMatrizCuadrada(n);
                else System.out.println("Primero debe crear la matriz");

            } else if (opcion == 3) {
                if (raiz != null) raiz.mostrarDiagonalPrincipal(n);
                else System.out.println("Primero debe crear la matriz");

            } else if (opcion == 4) {
                if (raiz != null) raiz.mostrarDiagonalSecundaria(n);
                else System.out.println("Primero debe crear la matriz");

            } else if (opcion == 5) {
                if (raiz != null) raiz.mostrarTriangularInferior(n);
                else System.out.println("Primero debe crear la matriz");

            } else if (opcion == 6) {
                if (raiz != null) raiz.mostrarTriangularSuperior(n);
                else System.out.println("Primero debe crear la matriz");

            } else if (opcion == 7) {
                System.out.println("Salir del programa");
                System.out.println("Programa finalizado");
                break;

            } else {
                System.out.println("Opcion invalida");
            }

        } while (true);
        keyboard.close();
    }

    public static void menu() {
        System.out.println("\n================== MENÚ MATRICES ==================");
        System.out.println("1 Crear matriz");
        System.out.println("2 Mostrar matriz");
        System.out.println("3 Mostrar diagonal principal");
        System.out.println("4 Mostrar diagonal secundaria");
        System.out.println("5 Mostrar triangular inferior");
        System.out.println("6 Mostrar triangular superior");
        System.out.println("7 Salir");
    }
}
