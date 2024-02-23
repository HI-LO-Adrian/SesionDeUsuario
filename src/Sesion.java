
//paquete de intefaz grafica
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
//paquetes para eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//paquetes que usaremos
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
//paquete de color y fondo
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class Sesion extends JFrame {
    // Atributos
    private JTextField entradaUsuario;
    private JPasswordField entradaContraseña;
    private JLabel texto1, texto2, titulo, textoAyuda;
    private JButton aceptar, cancelar, ayuda;
    private JPanel norte, central, sur;
    String usuario = "Adrian", contraseña = "1234";
    int contador = 0, numeroDeIntentos = 3;

    public Sesion() {
        Acciones realizaAcciones = new Acciones();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        // Primer Contenedor
        norte = new JPanel(new GridLayout(2, 1));
        titulo = new JLabel("AUTENTICACION", SwingConstants.CENTER);
        norte.add(titulo);
        contenedor.add(norte, BorderLayout.NORTH);
        norte.setBackground(Color.black);
        titulo.setForeground(Color.white);

        // Segundo Contenedor
        central = new JPanel(new GridLayout(3, 2));
        texto1 = new JLabel("Usuario", SwingConstants.CENTER);
        entradaUsuario = new JTextField(30);
        texto2 = new JLabel("Contraseña", SwingConstants.CENTER);
        entradaContraseña = new JPasswordField(30);
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(realizaAcciones);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(realizaAcciones);
        central.add(texto1);
        central.add(entradaUsuario);
        central.add(texto2);
        central.add(entradaContraseña);
        central.add(aceptar);
        central.add(cancelar);
        contenedor.add(central, BorderLayout.CENTER);
        central.setBackground(Color.black);
        texto1.setForeground(Color.white);
        texto2.setForeground(Color.white);
        entradaUsuario.setBackground(Color.black);
        entradaUsuario.setForeground(Color.white);
        entradaContraseña.setBackground(Color.black);
        entradaContraseña.setForeground(Color.white);
        aceptar.setBackground(Color.black);
        aceptar.setForeground(Color.white);
        cancelar.setBackground(Color.black);
        cancelar.setForeground(Color.white);

        // Contenedor Sur
        sur = new JPanel(new GridLayout(1, 2));
        textoAyuda = new JLabel("Da click al boton si neceitas ayuda", SwingConstants.CENTER);
        ayuda = new JButton("Ayuda");
        ayuda.addActionListener(realizaAcciones);
        sur.add(textoAyuda);
        sur.add(ayuda);
        contenedor.add(sur, BorderLayout.SOUTH);
        sur.setBackground(Color.BLACK);
        textoAyuda.setForeground(Color.white);
        ayuda.setBackground(Color.black);
        ayuda.setForeground(Color.white);

        setSize(500, 400);
        setVisible(true);
    }

    class Acciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            if (ev.getSource() == aceptar) {
                verificacionAceptar();
            }
            if (ev.getSource() == cancelar) {
                Cancelar();
            }
            if (ev.getSource() == ayuda) {
                Ayuda();
            }
        }
    }

    public void verificacionAceptar() {

        if (usuario.equals(entradaUsuario.getText()) && contraseña.equals(entradaContraseña.getText())) {
            Ventana2 ventanaDeAcceso = new Ventana2();
            ventanaDeAcceso.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña y/o usuario incorrecto");
            entradaUsuario.setText("");
            entradaContraseña.setText("");
            contador++;
        }
        if (contador == numeroDeIntentos) {
            VentanaUsuarioyContraseñaIncorrecta();
        }

    }

    public void Cancelar() {
        entradaUsuario.setText("");
        entradaContraseña.setText("");
    }

    public void Ayuda() {
        ApartadodeAyuda ventana4 = new ApartadodeAyuda();
        ventana4.setVisible(true);
        this.setVisible(false);

    }

    public void VentanaUsuarioyContraseñaIncorrecta() {
        SesionFallida segundaVentana = new SesionFallida();
        segundaVentana.setVisible(true);
        this.setVisible(false);

    }

    public static void main(String args[]) {
        Sesion ventana = new Sesion();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
