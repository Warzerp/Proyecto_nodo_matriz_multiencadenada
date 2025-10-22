import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PanelRedondeado extends JPanel {
    private Color colorFondo;
    private int radio;

    public PanelRedondeado(Color color, int radio) {
        this.colorFondo = color;
        this.radio = radio;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorFondo);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
    }
}

public class Interfaz extends JFrame {
    private JTextArea areaTexto;
    private JTextField txtN, txtMin, txtMax;
    private NodoM raiz;
    private int n;

    public Interfaz() {
        setTitle("Matriz Multienlazada");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(180, 255, 180));

        // titulo
        JLabel titulo = new JLabel("Matriz Multiencadenada", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(40, 80, 40));
        titulo.setBounds(200, 20, 450, 40);
        add(titulo);

        // panel de entradas
        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panelEntrada.setBounds(150, 70, 550, 40);
        panelEntrada.setBackground(new Color(180, 255, 180));

        panelEntrada.add(new JLabel("Tamano:"));
        txtN = new JTextField(5);
        panelEntrada.add(txtN);

        panelEntrada.add(new JLabel("Minimo:"));
        txtMin = new JTextField(5);
        panelEntrada.add(txtMin);

        panelEntrada.add(new JLabel("Maximo:"));
        txtMax = new JTextField(5);
        panelEntrada.add(txtMax);

        add(panelEntrada);

        // boton crear matriz
        JButton btnCrear = new JButton("Crear Matriz");
        btnCrear.setBounds(320, 120, 200, 35);
        btnCrear.setBackground(new Color(60, 130, 60));
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setFont(new Font("Arial", Font.BOLD, 15));
        btnCrear.setFocusPainted(false);
        btnCrear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnCrear);

        // panel redondeado
        PanelRedondeado panelMatriz = new PanelRedondeado(new Color(90, 90, 150), 50);
        panelMatriz.setLayout(new BorderLayout());
        panelMatriz.setBounds(80, 170, 680, 280);
        add(panelMatriz);

        // area de texto
        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Consolas", Font.BOLD, 14));
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setBackground(new Color(90, 150, 112));
        areaTexto.setEditable(false);
        areaTexto.setMargin(new Insets(20, 25, 20, 25));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        panelMatriz.add(scroll, BorderLayout.CENTER);

        // panel de botones inferiores
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelBotones.setBounds(100, 470, 640, 60);
        panelBotones.setBackground(new Color(180, 255, 180));
        add(panelBotones);

        JButton btnMostrar = crearBoton("Mostrar Matriz", new Color(60, 100, 170));
        JButton btnDiagonalP = crearBoton("Diagonal Principal", new Color(90, 90, 200));
        JButton btnDiagonalS = crearBoton("Diagonal Secundaria", new Color(190, 110, 70));
        JButton btnInferior = crearBoton("Triangular Inferior", new Color(100, 150, 100));
        JButton btnSuperior = crearBoton("Triangular Superior", new Color(150, 100, 160));
        JButton btnSalir = crearBoton("Salir", new Color(70, 70, 110));

        panelBotones.add(btnMostrar);
        panelBotones.add(btnDiagonalP);
        panelBotones.add(btnDiagonalS);
        panelBotones.add(btnInferior);
        panelBotones.add(btnSuperior);
        panelBotones.add(btnSalir);

        // acciones
        btnCrear.addActionListener(e -> crearMatriz());
        btnMostrar.addActionListener(e -> mostrarMatriz());
        btnDiagonalP.addActionListener(e -> mostrarDiagonalP());
        btnDiagonalS.addActionListener(e -> mostrarDiagonalS());
        btnInferior.addActionListener(e -> mostrarTriangularInferior());
        btnSuperior.addActionListener(e -> mostrarTriangularSuperior());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private JButton crearBoton(String texto, Color colorBase) {
        JButton b = new JButton(texto);
        b.setBackground(colorBase);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setBackground(colorBase.darker());
            }
            public void mouseExited(MouseEvent e) {
                b.setBackground(colorBase);
            }
        });
        return b;
    }

    private void mostrarTexto(String texto) {
        areaTexto.setText(texto);
    }

    private void crearMatriz() {
        try {
            n = Integer.parseInt(txtN.getText());
            int min = Integer.parseInt(txtMin.getText());
            int max = Integer.parseInt(txtMax.getText());
            raiz = NodoM.crearMatriz(n, min, max);
            mostrarTexto("Matriz creada correctamente.\nPresiona 'Mostrar Matriz' para verla.");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz().setVisible(true));
    }
}
