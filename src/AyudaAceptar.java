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
    
public class AyudaAceptar extends JFrame {
    //Atributos
    private JPanel norte, centro, sur;
    private JLabel titulo, texto;
    private JButton version, manual;
    
    //Metodos
    public AyudaAceptar(){
        Eventos accion = new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        norte = new JPanel(new GridLayout(1,1));
        titulo = new JLabel("Ayuda", SwingConstants.CENTER);
        norte.add(titulo);
        contenedor.add(norte, BorderLayout.NORTH);
        
        centro = new JPanel(new GridLayout(1,1));
        texto = new JLabel("¿Que es lo que desea hacer? ", SwingConstants.CENTER);
        centro.add(texto);
        contenedor.add(centro, BorderLayout.CENTER);
        
        sur = new JPanel(new GridLayout(1,2));
        version = new JButton("Version");
        version.addActionListener(accion);
        manual = new JButton("Manual de Uso");
        manual.addActionListener(accion);
        sur.add(version);
        sur.add(manual);
        contenedor.add(sur, BorderLayout.SOUTH);
        
        setSize(300,300);
        setVisible(true);
    }
    class Eventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==version){
                botonVersion();
            }
            if(ae.getSource()==manual){
                botonManual();
            }
        }
    }
    public void botonVersion(){
        InformacionPrograma ventana = new InformacionPrograma();
        ventana.setVisible(true);
        this.setVisible(false);
        
    }
    public void botonManual(){
        ManualPrograma ventana2 = new ManualPrograma();
        ventana2.setVisible(true);
        this.setVisible(false);
        
    }
}
