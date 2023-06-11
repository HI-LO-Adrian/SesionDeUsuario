//paquete de Polimorfismo
    import polimorfismo.Validacion;
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
//paquete para unidad 6 (Flujos y arhivos)
    import java.io.*;
    
public class Ventana2 extends JFrame implements Validacion{
     //atributos
   private JTextField entradaPeriodo;
   private JLabel periodo,semestre,materia,titulo, nombreUsuario;
   private JButton aceptar,cancelar;
   private JPanel norte,central,sur;
   private JComboBox pestanas,pestanasmate;
   //FIN ATRIBUTOS
   
   public Ventana2(){
       Eventos manejador = new Eventos();
       Container contenedor = getContentPane();
       contenedor.setLayout(new BorderLayout());
       
       norte = new JPanel(new GridLayout(2,1));
       titulo = new JLabel("BIENVENIDO",SwingConstants.CENTER);
       nombreUsuario = new JLabel("Gustavo Adrian Mendoza Monroy", SwingConstants.CENTER);
       central=new JPanel(new GridLayout(3,2));
       entradaPeriodo=new JTextField(10);
       periodo=new JLabel("PERIODO"); 
       semestre=new JLabel("SEMESTRE");
       String[]elementosN1={"1°SEMESTRE","2°SEMESTRE","3°SEMESTRE","4°SEMESTRE",
       "5°SEMESTRE","6°SEMESTRE","7°SEMESTRE","8°SEMESTRE"};
       pestanas=new JComboBox<>(elementosN1);
       materia=new JLabel("MATERIA");
       String[] elementosN2 ={""};
       pestanasmate=new JComboBox<>(elementosN2);
       
       sur=new JPanel(new GridLayout(1,1));
       aceptar=new JButton("Aceptar");
       aceptar.addActionListener(manejador);
       cancelar=new JButton("Cancelar");
       cancelar.addActionListener(manejador);
       
       norte.add(titulo);
       norte.add(nombreUsuario);
       central.add(periodo);
       central.add(entradaPeriodo);
       central.add(semestre);
       central.add(pestanas);
       central.add(materia);
       central.add(pestanasmate);
       sur.add(aceptar);
       sur.add(cancelar);
       
       
       contenedor.add(central,BorderLayout.CENTER);
       contenedor.add(norte,BorderLayout.NORTH);
       norte.setBackground(Color.BLACK);
       contenedor.add(sur,BorderLayout.SOUTH);
       setSize(500,400);
       setVisible(true);
       titulo.setForeground(Color.white);
       nombreUsuario.setForeground(Color.WHITE);
       central.setBackground(Color.black);
       periodo.setForeground(Color.white);
       semestre.setForeground(Color.white);
       materia.setForeground(Color.white);
       titulo.setForeground(Color.white);
       entradaPeriodo.setBackground(Color.black);
       entradaPeriodo.setForeground(Color.white);
       aceptar.setBackground(Color.black);
       aceptar.setForeground(Color.white);
       cancelar.setBackground(Color.black);
       cancelar.setForeground(Color.white);
       pestanas.addActionListener(ACE -> {
            String opcionSeleccionada = (String) pestanas.getSelectedItem();
            if (opcionSeleccionada.equals("1°SEMESTRE")) {
                String[] subopciones1 = {"Fundamentos de programacion"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones1) {
                    pestanasmate.addItem(subopcion);
                }
            } else if (opcionSeleccionada.equals("2°SEMESTRE")) {
                String[] subopciones2 = {"Programacion Orientada a Objetos"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones2) {
                    pestanasmate.addItem(subopcion);
                }
            } else if (opcionSeleccionada.equals("3°SEMESTRE")) {
                String[] subopciones2 = {"Estructura de Datos"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones2) {
                    pestanasmate.addItem(subopcion);
                }
            }else if (opcionSeleccionada.equals("4°SEMESTRE")) {
                String[] subopciones2 = {"Fundamentos de base de datos"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones2) {
                    pestanasmate.addItem(subopcion);
                }
            }else if (opcionSeleccionada.equals("5°SEMESTRE")) {
                String[] subopciones2 = {"Fundamentos de Ingenieria de Sofware"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones2) {
                    pestanasmate.addItem(subopcion);
                }
            }else if (opcionSeleccionada.equals("6°SEMESTRE")) {
                String[] subopciones2 = {"Programacion web"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones2) {
                    pestanasmate.addItem(subopcion);
                }
            } else if (opcionSeleccionada.equals("7°SEMESTRE")) {
                String[] subopciones2 = {"Programacion Logica Funcional"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones2) {
                    pestanasmate.addItem(subopcion);
                }
            }else {
                String[] subopciones3 = {"Inteligencia artificial"};
                pestanasmate.removeAllItems();
                for (String subopcion : subopciones3) {
                    pestanasmate.addItem(subopcion);
                }
            }
        }
    );
    }//Fin constructor
   public void borrar(){
       entradaPeriodo.setText("");
   }
   public void siguiente(){
      Ventana3 terceraVentana = new Ventana3();
      terceraVentana.setVisible(true);
      this.setVisible(false);
   } 
   class Eventos implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent ev){ 
           
           if(ev.getSource()==aceptar){
               unidad6Archivos();
               validacionGeneral();
           }
           if(ev.getSource()==cancelar){
               borrar();
           }
       }
       
   }
   //Metodo Implementado
   @Override
    public void validacionGeneral() {
        try{
            if(entradaPeriodo.getText().equals("")){
                JOptionPane.showMessageDialog(null,"El periodo esta en blanco");
            }else{
                siguiente();
            }
        }catch(NumberFormatException ae){
            JOptionPane.showMessageDialog(null, ae);
        }
    }
    
    public void unidad6Archivos(){
        File archivo = new File("C:\\Users\\Mendoza\\OneDrive\\Documentos\\"
                + "NetBeansProjects\\"+ "ProyectoInterfaz\\src\\Calificaciones\\"
                + "DatosParciales.txt");
         
        if(archivo.exists()==false){
            try{
                archivo.createNewFile();
            }catch(IOException io){
                JOptionPane.showMessageDialog(null, "Algo salio mal... \n" + io);
            }
        }
        
        try{
            File outputArchivo = new File(archivo.getAbsolutePath());
            FileWriter out = new FileWriter(outputArchivo);
            out.write("Nombre: " + nombreUsuario.getText() + "\n" + "Periodo: " + 
            entradaPeriodo.getText() + "\n" + "Semestre: " 
            + pestanas.getSelectedItem() + "\n" + "Materia: " + pestanasmate.getSelectedItem() + "\n\n");
            out.close();
        }catch(IOException io){
            JOptionPane.showMessageDialog(null,io);
        }
    }
    /*public static void main (String args[]){
        Ventana2 ventana = new Ventana2(); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
    
}



