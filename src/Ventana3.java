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
 //paquete de la undad 4
    import polimorfismo.Validacion;
//paquete de la unidad 6
    import java.io.*;
    
public class Ventana3 extends JFrame implements Validacion {
    //Atributos
    private JPanel norte, centro, sur;
    private JLabel titulo, calificacionLbl1, calificacionLbl2, calificacionLbl3, 
            calificacionLbl4, mensajeNotificacion,
            calificacionLbl5, calificacionLbl6, mensajePromedio, mostrarPromedio;
    public JTextField calificacionUno, calificacionDos, calificacionTres, calificacionCuatro, 
            calificacionCinco, calificacionSeis;
    private JButton aceptar, cancelar;
    int validacion1, validacion2, validacion3, validacion4, 
            validacion5, validacion6, numeroDeCalificaciones = 6;
    private float promedio;
    
    //Metodos
    public Ventana3(){
        Eventos accion = new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        norte = new JPanel(new GridLayout(2,1));
        titulo = new JLabel("Verfificador de Identidad", SwingConstants.CENTER);
        mensajeNotificacion = new JLabel("El programa se ejecutara correctamente solo " +
                "si el usuario aprobo todas las materias.", SwingConstants.CENTER);
        norte.add(titulo);
        norte.add(mensajeNotificacion);
        contenedor.add(norte, BorderLayout.NORTH);
        
        centro = new JPanel(new GridLayout(7,2));
        calificacionLbl1 = new JLabel("Ingrese la Calificacion de la Unidad 1", SwingConstants.CENTER);
        calificacionLbl2 = new JLabel("Ingrese la Calificacion de la Unidad 2", SwingConstants.CENTER);
        calificacionLbl3 = new JLabel("Ingrese la Calificacion de la Unidad 3", SwingConstants.CENTER);
        calificacionLbl4 = new JLabel("Ingrese la Calificacion de la Unidad 4", SwingConstants.CENTER);
        calificacionLbl5 = new JLabel("Ingrese la Calificacion de la Unidad 5", SwingConstants.CENTER);
        calificacionLbl6 = new JLabel("Ingrese la Calificacion de la Unidad 6", SwingConstants.CENTER);
        calificacionUno = new JTextField(30);
        calificacionDos = new JTextField(30);
        calificacionTres = new JTextField(30);
        calificacionCuatro = new JTextField(30);
        calificacionCinco = new JTextField(30);
        calificacionSeis = new JTextField(30);
        mensajePromedio = new JLabel("Tu promedio es: ");
        mostrarPromedio = new JLabel("0.0");
        centro.add(calificacionLbl1);
        centro.add(calificacionUno);
        centro.add(calificacionLbl2);
        centro.add(calificacionDos);
        centro.add(calificacionLbl3);
        centro.add(calificacionTres);
        centro.add( calificacionLbl4);
        centro.add(calificacionCuatro);
        centro.add(calificacionLbl5);
        centro.add(calificacionCinco);
        centro.add(calificacionLbl6);
        centro.add(calificacionSeis);
        centro.add(mensajePromedio);
        centro.add(mostrarPromedio);
        contenedor.add(centro, BorderLayout.CENTER);
        
        sur = new JPanel(new GridLayout(1,2));
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(accion);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(accion);
        sur.add(aceptar);
        sur.add(cancelar);
        contenedor.add(sur, BorderLayout.SOUTH);
        
        setSize(525,650);
        setVisible(true);
    }
    class Eventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == aceptar){
                if(calificacionUno.getText().equals("")||calificacionDos.
                        getText().equals("")||
                calificacionTres.getText().equals("")||calificacionCuatro.
                        getText().equals("")||
                calificacionCinco.getText().equals("")||calificacionSeis.
                        getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Casilla(s) en blanco");
                    
                }else{
                    validacionGeneral();
                    mostrarPromedio();
                    unidad6Archivos();
                    botonAceptar();
                }
            }
            if(ae.getSource()== cancelar){
                botonCancelar();
            }
        }
    }
    public void botonAceptar(){
        JOptionPane.showMessageDialog(null, "Datos registrados");
        System.exit(0);
    }
    public void botonCancelar(){
        calificacionUno.setText("");
        calificacionDos.setText("");
        calificacionTres.setText("");
        calificacionCuatro.setText("");
        calificacionCinco.setText("");
        calificacionSeis.setText("");
    }
    
    @Override
    public void validacionGeneral() {
        int a,b,c,d,e,f, indice = 0;
        try{
            
            validacion1 = Integer.parseInt(calificacionUno.getText());
            validacion2 = Integer.parseInt(calificacionDos.getText());
            validacion3 = Integer.parseInt(calificacionTres.getText());
            validacion4 = Integer.parseInt(calificacionCuatro.getText());
            validacion5 = Integer.parseInt(calificacionCinco.getText());
            validacion6 = Integer.parseInt(calificacionSeis.getText());
        
            if(validacion1 < 70){
                calificacionUno.setText("N/A");
            }else if(validacion1 > 100){
                calificacionUno.setText("Numero Invalido");
            }
            if(validacion2 < 70){
                calificacionDos.setText("N/A");
            }else if(validacion2 > 100){
                calificacionDos.setText("Numero Invalido");
            }
            if(validacion3 < 70){
                calificacionTres.setText("N/A");
            }else if(validacion3 > 100){
                calificacionTres.setText("Numero Invalido");
            }
            if(validacion4 < 70){
                calificacionCuatro.setText("N/A");
            }else if(validacion4 > 100){
                calificacionCuatro.setText("Numero Invalido");
            }
            if(validacion5 < 70){
                calificacionCinco.setText("N/A");
            }else if(validacion5 > 100){
                calificacionCinco.setText("Numero Invalido");
            }
            if(validacion6 < 70){
                calificacionSeis.setText("N/A");
            }else if(validacion6 > 100){
                calificacionSeis.setText("Numero Invalido");
            } 
        int array [] = new int [numeroDeCalificaciones];
        a = validacion1; 
        b = validacion2;
        c = validacion3;
        d = validacion4;
        e = validacion5;
        f = validacion6;
        array [0] = a;
        array [1] = b;
        array [2] = c;
        array [3] = d;
        array [4] = e;
        array [5] = f;
        System.out.println("Tus calificaciones son: ");
        
        for(int i = 0; i <array.length; i ++){
            indice = i +1;
            System.out.println("Calificacion : [" + (indice) + "]" + array[i]);
        }
        }catch(NumberFormatException nfe){
            //Exepcion para cuando no se puedan hacer un parseo correcto de Strings a  Números
        }catch(NullPointerException dba){
            //Exepcion para cuando aya datos en blanco
        }catch(ArrayIndexOutOfBoundsException eae){
            JOptionPane.showMessageDialog(null,"Imposible realizar la Operación" + eae);
            //Excepcion para el tamaño del arregglo
        }
    }
    public void mostrarPromedio(){
        try{
            int calValid1, calValid2, calValid3, calValid4, 
                    calValid5, calValid6;
            calValid1 = Integer.parseInt(calificacionUno.getText());
            calValid2 = Integer.parseInt(calificacionDos.getText());
            calValid3 = Integer.parseInt(calificacionTres.getText());
            calValid4 = Integer.parseInt(calificacionCuatro.getText());
            calValid5 = Integer.parseInt(calificacionCinco.getText());
            calValid6 = Integer.parseInt(calificacionSeis.getText());

            promedio = (calValid1 + calValid2 + calValid3 +
                    calValid4 + calValid5 + calValid6)/numeroDeCalificaciones;

            mostrarPromedio.setText(String.valueOf(promedio));
            

        }catch(ArithmeticException ae){
            JOptionPane.showMessageDialog(null,"No se puede capturar tu promedio" + ae );
            mostrarPromedio.setText("Promedio Invalido");
            //Se coloca este Catch por si ocurre algun error como al dividir entre cero.
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, dato invalido" + nfe );
            mostrarPromedio.setText("Promedio Invalido");
            //Exsepcion para no poder Realizar operaciones Aritemticas (promedio)
        }catch(NullPointerException db){
            JOptionPane.showMessageDialog(null,"Casillas en blanco");
            //Exepción para cuando no se capturan Datos 
        }
  
    }
    //En este metodo se guardara lo que ingrese el usuario en un archivo de txt. 
    public void unidad6Archivos(){
        String g,h,i,j,k,l;
        g = calificacionUno.getText();
        h = calificacionDos.getText();
        i = calificacionTres.getText();
        j = calificacionCuatro.getText();
        k = calificacionCinco.getText();
        l = calificacionSeis.getText();
        File inputArchivo = new File("C:\\Users\\Mendoza\\OneDrive\\Documentos\\"
                + "NetBeansProjects\\"+ "ProyectoInterfaz\\src\\Calificaciones\\"
                + "DatosParciales.txt");
        File outpoutArchivo = new File("C:\\Users\\Mendoza\\OneDrive\\Documentos\\"
                + "NetBeansProjects\\"+ "ProyectoInterfaz\\src\\Calificaciones\\"
                + "Calificaciones.txt");
         
        try{
            FileReader in = new FileReader(inputArchivo); //El in sirve para hacer una lectura de Datos
            FileWriter out = new FileWriter(outpoutArchivo);
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
                in.close();
                out.write("Aspecto: \tUnidad: \tCalififcacion: " + "\n" + "Calificación\t  1:"
                + " " +"\t\t" + g + "\n" + "Calificación\t  2: " + "\t\t" +h + "\n" +
                "Calificación\t  3: " + "\t\t" + i + "\n" + "Calificacion\t  4: " + "\t\t" + j + "\n" +
                "Calificación\t  5: " + "\t\t" + k + "\n" + "Calificación\t  6: " + "\t\t" + l + "\n" +
                "\n" + "Promedio: " + mostrarPromedio.getText());
                out.close();           
                JOptionPane.showMessageDialog(null, "El archivo de sus calificaciones " +
                "lo podra encontrar en: \n" + outpoutArchivo.getAbsolutePath() );
                
        }catch(IOException io2){
            JOptionPane.showMessageDialog(null,"Ooops: \n" + io2);
        }
        
    }
    
}
/*public static void main(String args[]){
        Ventana3 mesnajero = new Ventana3();
        mesnajero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
