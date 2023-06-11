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
public class ApartadodeAyuda extends JFrame{
    //Atributos
    private JPanel norte, centro, sur;
    private JLabel titulo, nombres, apellidos, numeroTelefonico;
    private JTextField usuarioNombre, usuarioApellidos, usuarioTelefono;
    private JButton aceptar, limpiar, salir;

    //Metodos
    public ApartadodeAyuda(){
        Eventos accion = new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        norte = new JPanel(new GridLayout(1,1));
        titulo = new JLabel("AYUDA", SwingConstants.CENTER);
        norte.add(titulo);
        contenedor.add(norte,BorderLayout.NORTH);
        
        centro = new JPanel(new GridLayout(3,2));
        nombres = new JLabel("Nombre Completo: ", SwingConstants.CENTER);
        apellidos = new JLabel("Apellido completo: ", SwingConstants.CENTER);
        numeroTelefonico = new JLabel("Numero de telefono: ", SwingConstants.CENTER);
        usuarioNombre = new JTextField(30);
        usuarioApellidos = new JTextField(30);
        usuarioTelefono = new JTextField(30);
        centro.add(nombres);
        centro.add(usuarioNombre);
        centro.add(apellidos);
        centro.add(usuarioApellidos);
        centro.add(numeroTelefonico);
        centro.add(usuarioTelefono);
        contenedor.add(centro, BorderLayout.CENTER);
        
        sur = new JPanel(new GridLayout(1,3));
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(accion);
        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(accion);
        salir = new JButton("Salir");
        salir.addActionListener(accion);
        sur.add(aceptar);
        sur.add(limpiar);
        sur.add(salir);
        contenedor.add(sur, BorderLayout.SOUTH);
        
        setSize(500,300);
        setVisible(true);
    }
    class Eventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==aceptar){
                botonAceptar();
            }
            if(ae.getSource()==limpiar){
                botonLimpiar();
            }
            if(ae.getSource()==salir){
                botonSalir();
            }
        }
    }
    public void botonAceptar(){
        JOptionPane.showMessageDialog(null,"Datos Registrados Correctamente");
        AyudaAceptar ventana5 = new AyudaAceptar();
        ventana5.setVisible(true);
        this.setVisible(false);
    }
    public void botonLimpiar(){
        usuarioNombre.setText("ej.Marty");
        usuarioApellidos.setText("ej.Monroe Montemayor");
        usuarioTelefono.setText("ej. 999 999 999");
    }
    public void botonSalir(){
        JOptionPane.showMessageDialog(null, "Operacion Cancelada");
        System.exit(0);
    }
    
}
