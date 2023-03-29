import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Residuos extends JPanel implements ItemListener, ActionListener{
    private JLabel labelResiduo;
    private JComboBox<String> opResiduos;
    private JLabel labelNombre;
    private JTextField nombre;
    private JLabel labelDocumento;
    private JTextField documento;
    private JTextArea textField;
    private JButton bSalida;
    private JTextArea salida;
    

    public Residuos() {

        //construct components
        labelResiduo = new JLabel ("Tipo de Residuo");
        opResiduos = new JComboBox <String>();
        labelNombre = new JLabel ("Nombre");
        nombre = new JTextField (5);
        labelDocumento = new JLabel ("Documento");
        documento = new JTextField (5);
        textField = new JTextArea (5, 5);
        bSalida = new JButton ("Cerrar");

        //set components properties
        opResiduos.setToolTipText ("Selecciona el tipo de residuo que quieras botar.");
        textField.setEnabled (false);
        bSalida.setToolTipText ("Oprime este boton cuando quieras salir del programa.");

        //adjust size and set layout
        setPreferredSize (new Dimension (784, 461));
        setLayout (null);

        //add components
        add (labelResiduo);
        add (opResiduos);
        opResiduos.addItemListener(this);
        opResiduos.addItem("vacio");
        opResiduos.addItem("Organico");
        opResiduos.addItem("Inorganico");
        opResiduos.addItem("Reciclable");
        add (labelNombre);
        add (nombre);
        add (labelDocumento);
        add (documento);
        add (textField);
        add (bSalida);
        bSalida.addActionListener(this);

        //set component bounds (only needed by Absolute Positioning)
        labelResiduo.setBounds (190, 90, 100, 25);
        labelResiduo.setFont(new java.awt.Font("Arial",1,12));
        opResiduos.setBounds (190, 120, 100, 25);
        opResiduos.setFont(new java.awt.Font("Arial",1,12));
        labelNombre.setBounds (325, 90, 100, 25);
        labelNombre.setFont(new java.awt.Font("Arial",1,12));
        nombre.setBounds (325, 120, 100, 25);
        nombre.setFont(new java.awt.Font("Arial",1,12));
        labelDocumento.setBounds (460, 90, 100, 25);
        labelDocumento.setFont(new java.awt.Font("Arial",1,12));
        documento.setBounds (460, 120, 100, 25);
        documento.setFont(new java.awt.Font("Arial",1,12));
        textField.setBounds (190, 170, 370, 120);
        textField.setFont(new java.awt.Font("Arial",1,14));
        bSalida.setBounds (460, 305, 100, 25);
        bSalida.setFont(new java.awt.Font("Arial",1,12));

        //Paneles colores
        setBackground (new Color (0, 102, 0));
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==opResiduos) {
            String seleccionado=(String)opResiduos.getSelectedItem();
            if (seleccionado.equals("Organico")) {
                String org = Organico();
                textField.setText(org);
            } else if (seleccionado.equals("Inorganico")) {
                String inorg = Inorganico();
                textField.setText(inorg);
            } else if (seleccionado.equals("Reciclable")) {
                String rec = Reciclable();
                textField.setText(rec);
            } else {
                textField.setText("No se ha seleccionado ningun residuo.");
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==bSalida) {
            Exit();
        }
    }

    public void Menu(){
        JFrame frame = new JFrame ("Residuos");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Residuos());
        frame.pack();
        frame.setVisible (true);
    }

    public String Organico(){
        String nom = nombre.getText();
        String doc = documento.getText();
        String texto = (nom + ", con identificacion " + doc + ", \ntu residuo es organico. Debe ir en la basura verde.");
        return texto;
    }

    public String Inorganico(){
        String nom = nombre.getText();
        String doc = documento.getText();
        String texto = (nom + ", con identificacion " + doc + ", \ntu residuo es inorganico. Debe ir en la basura negro.");
        return texto;
    }

    public String Reciclable(){
        String nom = nombre.getText();
        String doc = documento.getText();
        String texto = (nom + ", con identificacion " + doc + ", \ntu residuo es reciclable. Debe ir en la basura blanco.");
        return texto;
    }

    public void Exit(){
        salida = new JTextArea(5,5);
        salida.setEnabled(false);
        setPreferredSize (new Dimension (784, 461));
        setLayout (null);
        add(salida);
        salida.setBounds(45, 205, 500, 200);
        System.exit(0);
    }

    /*public void Salida(){
        JFrame frame = new JFrame ("Salida");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Residuos());
        frame.pack();
        frame.setVisible (true);
    }*/

    public static void main (String[] args) {
        (new Residuos()).Menu();
    }
}

