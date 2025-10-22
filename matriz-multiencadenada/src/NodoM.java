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

    public Object obtenerValor(){
        return valor;
    }

    public void enlazarSiguiente(NodoM siguiente) {
        this.siguiente = siguiente;
    }

    public void enlazarAnterior(NodoM anterior) {
        this.anterior = anterior;
    }

    public void enlazarSuperior(NodoM superior) {
        this.superior = superior;
    }
    public void enlazarInferior(NodoM inferior) {
        this.inferior = inferior;
    }

    public NodoM obtenerSiguiente() {
        return siguiente; }

    public NodoM obtenerAnterior() { return anterior;
    }

    public NodoM obtenerSuperior() {
        return superior;
    }

    public NodoM obtenerInferior() {
        return inferior;
    }

    public Object getValor() {
        return valor; }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    // Crea y devuelve la raíz (0,0) de una matriz cuadrada n x n
    public static NodoM crearMatriz(int n, int minRandom, int maxRandom) {
        if (n <= 0) throw new IllegalArgumentException("n debe ser mayor que 0");
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

    // Imprime la matriz asumiendo que this es la raíz (0,0) de una matriz cuadrada
    public void imprimirMatrizCuadrada(int n) {
        NodoM fila = this;
        for (int i = 0; i < n; i++) {
            NodoM actual = fila;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(actual.getValor());
                if (j < n - 1) sb.append(" ");
                actual = actual.obtenerSiguiente();
            }
            System.out.println(sb.toString());
            fila = fila.obtenerInferior();
        }

    }


}

