import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Entrada extends JPanel implements ItemListener, ActionListener{
    private JLabel labelResiduo;
    static JComboBox<String> opResiduos;
    private JLabel labelNombre;
    static JTextField nombre;
    private JLabel labelDocumento;
    static JTextField documento;
    private JTextArea textField;
    private JButton bDone;
    private JLabel labelColor;
    static JTextField colorBasura;
    static String color;

    public Entrada() {

        //construct components
        labelResiduo = new JLabel ("Material del Residuo");
        opResiduos = new JComboBox <String>();
        labelNombre = new JLabel ("Nombre");
        nombre = new JTextField (5);
        labelDocumento = new JLabel ("Documento");
        documento = new JTextField (5);
        textField = new JTextArea (5, 5);
        bDone = new JButton ("Done");
        labelColor = new JLabel ("Color");
        colorBasura = new JTextField (5);

        //set components properties
        opResiduos.setToolTipText ("Selecciona el material de su residuo.");
        textField.setEnabled (false);
        bDone.setToolTipText ("Oprime este boton cuando quieras salir del programa.");

        //adjust size and set layout
        setPreferredSize (new Dimension (784, 461));
        setLayout (null);

        //add components
        add (labelResiduo);
        add (opResiduos);
        opResiduos.addItemListener(this);
        opResiduos.addItem("vacio");
        opResiduos.addItem("Papel");
        opResiduos.addItem("Carton");
        opResiduos.addItem("Plastico");
        opResiduos.addItem("Restos de comida");
        opResiduos.addItem("Restos de cafe");
        opResiduos.addItem("Restos de te");
        opResiduos.addItem("Productos de higiene personal");
        opResiduos.addItem("Productos de uso unico");
        add (labelNombre);
        add (nombre);
        add (labelDocumento);
        add (documento);
        add (textField);
        add (bDone);
        bDone.addActionListener(this);
        add (labelColor);
        add (colorBasura);

        //set component bounds (only needed by Absolute Positioning)
        labelResiduo.setBounds (190, 90, 125, 25);
        labelResiduo.setFont(new java.awt.Font("Arial",1,12));
        opResiduos.setBounds (190, 120, 125, 25);
        opResiduos.setFont(new java.awt.Font("Arial",1,12));
        labelColor.setBounds (360, 90, 125, 25);
        labelColor.setFont(new java.awt.Font("Arial",1,12));
        colorBasura.setBounds (360, 120, 125, 25);
        colorBasura.setFont(new java.awt.Font("Arial",1,12));
        labelDocumento.setBounds (360,170, 125, 25);
        labelDocumento.setFont(new java.awt.Font("Arial",1,12));
        documento.setBounds (360, 200, 125, 25);
        documento.setFont(new java.awt.Font("Arial",1,12));
        textField.setBounds (145, 240, 370, 115);
        textField.setFont(new java.awt.Font("Arial",1,14));
        bDone.setBounds (360, 380, 100, 25);
        bDone.setFont(new java.awt.Font("Arial",1,12));
        labelNombre.setBounds(190,170,125,25);
        labelNombre.setFont(new java.awt.Font("Arial",1,12));
        nombre.setBounds(190,200,125,25);
        nombre.setFont(new java.awt.Font("Arial",1,12));

        //Paneles colores
        setBackground (new Color (150, 240, 75));
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==opResiduos) {
            String seleccionado=(String)opResiduos.getSelectedItem();
            if (seleccionado.equals("Papel")||seleccionado.equals("Carton")||seleccionado.equals("Plastico")) {
                Reciclable reciclable = new Reciclable();
                color = reciclable.getColor();
                textField.setText(Procesamiento.indicarCaneca() + reciclable.getColor());
            } else if (seleccionado.equals("Restos de comida")||seleccionado.equals("Restos de cafe")||seleccionado.equals("Restos de te")) {
                Organico organico = new Organico();
                color = organico.getColor();
                textField.setText(Procesamiento.indicarCaneca() + organico.getColor());
            } else if (seleccionado.equals("Productos de higiene personal")||seleccionado.equals("Productos de uso unico")) {
                Inorganico inorganico = new Inorganico();
                color = inorganico.getColor();
                textField.setText(Procesamiento.indicarCaneca() + inorganico.getColor());
            } else {
                textField.setText("No se ha seleccionado ningun residuo.");
            }
        }
    }

    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==bDone) {
            JFrame frame = new JFrame("Calificacion");
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add (new Salida());
                frame.pack();
                frame.setVisible (true);
        }
    }

    public void Menu(){
        JFrame frame = new JFrame ("Residuos");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Entrada());
        frame.pack();
        frame.setVisible (true);
    }

    public static String pedirNombre(){
        String name = nombre.getText();
        return name;
    }

    public static String pedirIdentificacion(){
        String id = documento.getText();
        return id;
    }

    public static String pedirColor(){
        String color = colorBasura.getText();
        return color;
    }

    public static String pedirMaterial(){
        String material = (String)opResiduos.getSelectedItem();
        return material;
    }

}
