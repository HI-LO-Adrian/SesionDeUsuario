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
    
public class InformacionPrograma extends JFrame {
    //Atributos
    private JPanel norte, centro, sur;
    private JLabel titulo, nombre, miNombre, version, noVersion, fecha, fechaActual;
    private JButton volver, salir;
    
    //Metodos
    InformacionPrograma(){
        Eventos acciones = new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        norte = new JPanel(new GridLayout(1,1));
        titulo = new JLabel ("Informacion", SwingConstants.CENTER);
        norte.add(titulo);
        contenedor.add(norte, BorderLayout.NORTH);
        
        centro = new JPanel (new GridLayout(3,3));
        nombre = new JLabel("Nombre: ", SwingConstants.CENTER);
        miNombre = new JLabel("Gustavo Adrian Mendoza Monory ", SwingConstants.CENTER);
        version = new JLabel("Version: ", SwingConstants.CENTER);
        noVersion = new JLabel("1.0 ", SwingConstants.CENTER);
        fecha = new JLabel("Fecha: ", SwingConstants.CENTER);
        fechaActual = new JLabel("2023 ", SwingConstants.CENTER);
        centro.add(nombre);
        centro.add(miNombre);
        centro.add(version);
        centro.add(noVersion);
        centro.add(fecha);
        centro.add(fechaActual);
        contenedor.add(centro, BorderLayout.CENTER);
        
        sur = new JPanel(new GridLayout(1,2));
        volver = new JButton("Volver");
        volver.addActionListener(acciones);
        salir = new JButton("Salir");
        salir.addActionListener(acciones);
        sur.add(volver);
        sur.add(salir);
        contenedor.add(sur, BorderLayout.SOUTH);
        
        setSize(500,400);
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
