import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int opcion = 0;
        NodoM raiz = null;
        int ultimoN = 0;

        do {
            menu();
            System.out.print("Ingrese una opcion: ");
            opcion = keyboard.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese tamaño de la matriz: ");
                int n = keyboard.nextInt();
                System.out.println("Ingresa el valor minimo que tendra el valor de los nodos");
                int minRandom = keyboard.nextInt();
                System.out.println("Ingresa el valor maximo que tendra el valor de los nodos");
                int maxRandom = keyboard.nextInt();
                raiz = NodoM.crearMatriz(n, minRandom, maxRandom);
                ultimoN = n;
                System.out.println("Muy bien hecho, matriz creada");
            } else if (opcion == 2) {
                if (raiz == null) {
                    System.out.println("No hay matriz creada.");
                } else {
                    raiz.imprimirMatrizCuadrada(ultimoN);
                }
            } else if (opcion == 3) {
                // implementar mostrar diagonal principal cuando lo necesites
            } else if (opcion == 4) {
                // implementar mostrar diagonal secundaria cuando lo necesites
            } else if (opcion == 5) {
                // implementar mostrar triangular inferior cuando lo necesites
            } else if (opcion == 6) {
                // implementar mostrar triangular superior cuando lo necesites
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

