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
    
public class SesionFallida extends JFrame {
    
    //Atributos
    private JPanel centro;
    private JLabel texto1, texto2, texto3;
    private JButton ayuda;
    
    //Metodos
    public SesionFallida(){
        Acciones evento = new Acciones();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        centro = new JPanel(new GridLayout(4,1));
        texto1 = new JLabel("Limite de intentos halcanzado,", SwingConstants.CENTER);
        texto2 = new JLabel("si crees que se trata de un herror", SwingConstants.CENTER);
        texto3 = new JLabel("da click al boton de abajo: ", SwingConstants.CENTER);
        ayuda = new JButton("Ayuda");
        ayuda.addActionListener(evento);
        centro.add(texto1);
        centro.add(texto2);
        centro.add(texto3);
        centro.add(ayuda);
        contenedor.add(centro,BorderLayout.CENTER);
        centro.setBackground(Color.black);
        texto1.setForeground(Color.white);
        texto2.setForeground(Color.white);
        texto3.setForeground(Color.white);
        ayuda.setBackground(Color.black);
        ayuda.setForeground(Color.white);
        
        setSize(500,500);
        setVisible(true);
    }
    class Acciones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ev) {
           if(ev.getSource()== ayuda){
               ayudaAccion();
           }
        }
    }
    
    public void ayudaAccion (){
        JOptionPane.showMessageDialog(null,"No se encontro la pagina");
        System.exit(0);
    }
    
    
}
