import java.util.Random;

public class NodoM {
    private Object valor;
    private NodoM siguiente;
    private NodoM anterior;
    private NodoM superior;
    private NodoM inferior;

    public NodoM(Object valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
        this.superior = null;
        this.inferior = null;
    }

    public Object getValor() { return valor; }
    public void setValor(Object valor) { this.valor = valor; }

    public void enlazarSiguiente(NodoM siguiente) { this.siguiente = siguiente; }
    public void enlazarAnterior(NodoM anterior) { this.anterior = anterior; }
    public void enlazarSuperior(NodoM superior) { this.superior = superior; }
    public void enlazarInferior(NodoM inferior) { this.inferior = inferior; }

    public NodoM obtenerSiguiente() { return siguiente; }
    public NodoM obtenerAnterior() { return anterior; }
    public NodoM obtenerSuperior() { return superior; }
    public NodoM obtenerInferior() { return inferior; }

    // Mostrar matriz con flechas de enlace
    public void imprimirMatrizCuadrada(int n) {
        NodoM fila = this;

        for (int i = 0; i < n; i++) {
            NodoM actual = fila;

            // Línea superior (flechas hacia arriba)
            for (int j = 0; j < n; j++) {
                if (actual.obtenerSuperior() != null)
                    System.out.print("   ↑   ");
                else
                    System.out.print("       ");
                actual = actual.obtenerSiguiente();
            }
            System.out.println();

            // Linea central (izquierda, valor, derecha)
            actual = fila;
            for (int j = 0; j < n; j++) {
                String izq = actual.obtenerAnterior() != null ? "←" : "  ";
                String der = actual.obtenerSiguiente() != null ? "→" : "  ";
                System.out.print(izq + "[" + actual.getValor() + "]" + der + " ");
                actual = actual.obtenerSiguiente();
            }
            System.out.println();

            // Linea inferior (flechas hacia abajo)
            actual = fila;
            for (int j = 0; j < n; j++) {
                if (actual.obtenerInferior() != null)
                    System.out.print("   ↓   ");
                else
                    System.out.print("       ");
                actual = actual.obtenerSiguiente();
            }
            System.out.println("\n");

            fila = fila.obtenerInferior();
        }
    }

    public static NodoM crearMatriz(int n, int minRandom, int maxRandom) {
        Random rnd = new Random();
        NodoM[][] aux = new NodoM[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int valorAleatorio = rnd.nextInt(maxRandom - minRandom + 1) + minRandom;
                aux[i][j] = new NodoM(valorAleatorio);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    aux[i][j].enlazarSiguiente(aux[i][j + 1]);
                    aux[i][j + 1].enlazarAnterior(aux[i][j]);
                }
                if (i + 1 < n) {
                    aux[i][j].enlazarInferior(aux[i + 1][j]);
                    aux[i + 1][j].enlazarSuperior(aux[i][j]);
                }
            }
        }

        return aux[0][0];
    }

    public void mostrarDiagonalPrincipal(int n) {
        NodoM actual = this;
        System.out.print("Diagonal principal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(actual.getValor() + " ");
            if (actual.obtenerSiguiente() != null && actual.obtenerInferior() != null)
                actual = actual.obtenerSiguiente().obtenerInferior();
        }
        System.out.println();
    }

    public void mostrarDiagonalSecundaria(int n) {
        NodoM actual = this;
        for (int j = 1; j < n; j++)
            actual = actual.obtenerSiguiente();
        System.out.print("Diagonal secundaria: ");
        for (int i = 0; i < n; i++) {
            System.out.print(actual.getValor() + " ");
            if (actual.obtenerAnterior() != null && actual.obtenerInferior() != null)
                actual = actual.obtenerAnterior().obtenerInferior();
        }
        System.out.println();
    }

    public void mostrarTriangularInferior(int n) {
        NodoM fila = this;
        System.out.println("Triangular inferior:");
        for (int i = 0; i < n; i++) {
            NodoM actual = fila;
            for (int j = 0; j < n; j++) {
                if (j <= i)
                    System.out.print(actual.getValor() + "\t");
                else
                    System.out.print(" \t");
                actual = actual.obtenerSiguiente();
            }
            System.out.println();
            fila = fila.obtenerInferior();
        }
    }

    public void mostrarTriangularSuperior(int n) {
        NodoM fila = this;
        System.out.println("Triangular superior:");
        for (int i = 0; i < n; i++) {
            NodoM actual = fila;
            for (int j = 0; j < n; j++) {
                if (j >= i)
                    System.out.print(actual.getValor() + "\t");
                else
                    System.out.print(" \t");
                actual = actual.obtenerSiguiente();
            }
            System.out.println();
            fila = fila.obtenerInferior();
        }
    }
}
