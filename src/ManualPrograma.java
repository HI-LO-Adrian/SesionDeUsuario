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
    
public class ManualPrograma extends JFrame {
    //Atributos
    private JPanel norte, centro, sur;
    private JLabel titulo,paso1, paso2, paso3, paso4, paso5;
    private JButton volver, salir;
    
    //Metodos
    ManualPrograma(){
        Eventos accion = new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        norte = new JPanel(new GridLayout(1,1));
        titulo = new JLabel("MANUAL DE USO", SwingConstants.CENTER);
        norte.add(titulo);
        contenedor.add(norte, BorderLayout.NORTH);
        
        centro = new JPanel(new GridLayout(5,1));
        paso1 = new JLabel("1.- Ingresar Usuario", SwingConstants.CENTER);
        paso2 = new JLabel("2.- Ingresar Contraseña", SwingConstants.CENTER);
        paso3 = new JLabel("3.- En caso de necesitar ayuda, da click en " + "Ayuda", SwingConstants.CENTER);
        paso4 = new JLabel("4.- Si el usuario y/o contraseña son incorrectos se habrira una pestaña de ayuda", SwingConstants.CENTER);
        paso5 = new JLabel("5.- Si todo es correctos, coloca lo que se solicita", SwingConstants.CENTER);
        centro.add(paso1);
        centro.add(paso2);
        centro.add(paso3);
        centro.add(paso4);
        centro.add(paso5);
        contenedor.add(centro, BorderLayout.CENTER);
        
        sur = new JPanel(new GridLayout(1,2));
        volver = new JButton("Volver");
        volver.addActionListener(accion);
        salir = new JButton("Salir");
        salir.addActionListener(accion);
        sur.add(volver);
        sur.add(salir);
        contenedor.add(sur, BorderLayout.SOUTH);
        
        setSize(600,700);
        setVisible(true);
    }
    class Eventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==volver){
                botonVolver();
            }
            if(ae.getSource()==salir){
                botonSalir();
            }
        }
    }
    public void botonVolver(){
        AyudaAceptar ventana = new AyudaAceptar();
        ventana.setVisible(true);
        this.setVisible(false);
    }
    public void botonSalir(){
        JOptionPane.showMessageDialog(null, "Gracias por utilizar este programa");
        System.exit(0);
    }
    
}
