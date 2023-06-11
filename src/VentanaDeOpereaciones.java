//paquete de intefaz grafica
    import java.awt.Container;
    import java.awt.BorderLayout;
    import java.awt.Color;
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
    import javax.swing.JComboBox;
    import javax.swing.SwingConstants;
//paquete de color y fondo
    import java.awt.Font;
    import javax.swing.JOptionPane;
public class VentanaDeOpereaciones extends JFrame{
    private JPanel norte, centro, sur;
    private JLabel textoValor1, textoValor2, TextoResultado, titulo;
    private JTextField inNumero1, inNumero2;
    
    public VentanaDeOpereaciones (){
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        norte = new JPanel(new GridLayout(1,1));
        titulo = new JLabel("Ventana Para Probar Excepciones", SwingConstants.CENTER);
        norte.add(titulo);
        contenedor.add(norte, BorderLayout.NORTH);
        
        centro = new JPanel(new GridLayout(3,2));
    }
}
