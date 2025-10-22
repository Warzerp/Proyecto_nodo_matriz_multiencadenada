import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz extends JFrame {
    private JPanel panelBotones;
    private JPanel panelMatriz;
    private JTextArea areaTexto;
    private JButton btnCrear, btnMostrar, btnDiagonalP, btnDiagonalS, btnInferior, btnSuperior;
    private NodoM raiz;
    private int n;

    public Interfaz() {
        setTitle("Matriz Multienlazada");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(170, 255, 170));

        // PANEL DE BOTONES (izquierda)
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 1, 10, 10));
        panelBotones.setBounds(50, 80, 180, 300);
        panelBotones.setBackground(new Color(90, 90, 150));

        btnCrear = crearBoton("Crear Matriz");
        btnMostrar = crearBoton("Mostrar Matriz");
        btnDiagonalP = crearBoton("Diagonal Principal");
        btnDiagonalS = crearBoton("Diagonal Secundaria");
        btnInferior = crearBoton("Triangular Inferior");
        btnSuperior = crearBoton("Triangular Superior");

        panelBotones.add(btnCrear);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnDiagonalP);
        panelBotones.add(btnDiagonalS);
        panelBotones.add(btnInferior);
        panelBotones.add(btnSuperior);
        add(panelBotones);

        // PANEL MATRIZ / TEXTO (derecha)
        panelMatriz = new JPanel();
        panelMatriz.setLayout(new BorderLayout());
        panelMatriz.setBackground(new Color(90, 90, 150));
        panelMatriz.setBounds(280, 70, 370, 300);
        add(panelMatriz);

        // Área de texto
        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Monospaced", Font.BOLD, 14));
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setBackground(new Color(90, 90, 150));
        areaTexto.setEditable(false);
        panelMatriz.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // BOTON SALIR
        JButton btnSalir = new JButton("SALIR");
        btnSalir.setBounds(550, 400, 100, 40);
        btnSalir.setBackground(new Color(90, 90, 150)); 
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnSalir);

        // ACCIONES
        btnCrear.addActionListener(e -> crearMatriz());
        btnMostrar.addActionListener(e -> mostrarMatriz());
        btnDiagonalP.addActionListener(e -> mostrarDiagonalP());
        btnDiagonalS.addActionListener(e -> mostrarDiagonalS());
        btnInferior.addActionListener(e -> mostrarTriangularInferior());
        btnSuperior.addActionListener(e -> mostrarTriangularSuperior());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setBackground(new Color(90, 90, 150));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        return b;
    }

    // ==== ACCIONES ====

    private void mostrarTexto(String texto) {
        areaTexto.setText(texto);
    }

    private void crearMatriz() {
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese tamaño de la matriz:"));
            int min = Integer.parseInt(JOptionPane.showInputDialog("Valor minimo:"));
            int max = Integer.parseInt(JOptionPane.showInputDialog("Valor maximo:"));
            raiz = NodoM.crearMatriz(n, min, max);
            JOptionPane.showMessageDialog(this, "Matriz creada correctamente");
            mostrarTexto("Matriz creada correctamente.\nPresiona 'Mostrar Matriz' para verla");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear la matriz");
        }
    }

    private void mostrarMatriz() {
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la matriz");
            return;
        }
        mostrarTexto(generarTextoMatriz());
    }

    private void mostrarDiagonalP() {
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la matriz");
            return;
        }
        mostrarTexto(generarTextoDiagonalPrincipal());
    }

    private void mostrarDiagonalS() {
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la matriz");
            return;
        }
        mostrarTexto(generarTextoDiagonalSecundaria());
    }

    private void mostrarTriangularInferior() {
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la matriz");
            return;
        }
        mostrarTexto(generarTextoTriangularInferior());
    }

    private void mostrarTriangularSuperior() {
        if (raiz == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la matriz");
            return;
        }
        mostrarTexto(generarTextoTriangularSuperior());
    }

    // ==== FUNCIONES DE MATRIZ ====

    private String generarTextoMatriz() {
        StringBuilder sb = new StringBuilder("Matriz:\n");
        NodoM fila = raiz;
        for (int i = 0; i < n; i++) {
            NodoM actual = fila;
            for (int j = 0; j < n; j++) {
                sb.append(actual.getValor()).append("\t");
                actual = actual.obtenerSiguiente();
            }
            sb.append("\n");
            fila = fila.obtenerInferior();
        }
        return sb.toString();
    }

    private String generarTextoDiagonalPrincipal() {
        StringBuilder sb = new StringBuilder("Diagonal Principal:\n");
        NodoM actual = raiz;
        for (int i = 0; i < n; i++) {
            sb.append(actual.getValor()).append("\t");
            if (actual.obtenerSiguiente() != null && actual.obtenerInferior() != null)
                actual = actual.obtenerSiguiente().obtenerInferior();
        }
        return sb.toString();
    }

    private String generarTextoDiagonalSecundaria() {
        StringBuilder sb = new StringBuilder("Diagonal Secundaria:\n");
        NodoM actual = raiz;
        for (int j = 1; j < n; j++)
            actual = actual.obtenerSiguiente();
        for (int i = 0; i < n; i++) {
            sb.append(actual.getValor()).append("\t");
            if (actual.obtenerAnterior() != null && actual.obtenerInferior() != null)
                actual = actual.obtenerAnterior().obtenerInferior();
        }
        return sb.toString();
    }

    private String generarTextoTriangularInferior() {
        StringBuilder sb = new StringBuilder("Triangular Inferior:\n");
        NodoM fila = raiz;
        for (int i = 0; i < n; i++) {
            NodoM actual = fila;
            for (int j = 0; j < n; j++) {
                sb.append((j <= i ? actual.getValor() : " ")).append("\t");
                actual = actual.obtenerSiguiente();
            }
            sb.append("\n");
            fila = fila.obtenerInferior();
        }
        return sb.toString();
    }

    private String generarTextoTriangularSuperior() {
        StringBuilder sb = new StringBuilder("Triangular Superior:\n");
        NodoM fila = raiz;
        for (int i = 0; i < n; i++) {
            NodoM actual = fila;
            for (int j = 0; j < n; j++) {
                sb.append((j >= i ? actual.getValor() : " ")).append("\t");
                actual = actual.obtenerSiguiente();
            }
            sb.append("\n");
            fila = fila.obtenerInferior();
        }
        return sb.toString();
    }

    // MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz().setVisible(true));
    }
}

