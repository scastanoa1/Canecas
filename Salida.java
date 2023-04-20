import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Salida extends JPanel implements ItemListener, ActionListener{
    private JLabel labelCalificacion;
    static JComboBox<String> opCalificacion;
    private JTextArea textArea;
    private JButton bExit;
    public Salida() {

        //construct components
        labelCalificacion = new JLabel ("Calificacion");
        opCalificacion = new JComboBox <String>();
        textArea = new JTextArea (5, 5);
        bExit = new JButton ("Exit");

        //set components properties
        opCalificacion.setToolTipText ("Selecciona la calificacion que quieras darle al servicio.");
        textArea.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (784, 461));
        setLayout (null);

        //add components
        add (labelCalificacion);
        add (opCalificacion);
        opCalificacion.addItemListener(this);
        opCalificacion.addItem("vacio");
        opCalificacion.addItem("Muy buena");
        opCalificacion.addItem("Buena");
        opCalificacion.addItem("Regular");
        opCalificacion.addItem("Mala");
        opCalificacion.addItem("Muy mala");
        add (textArea);
        add(bExit);
        bExit.addActionListener(this);

        //set component bounds (only needed by Absolute Positioning)
        labelCalificacion.setBounds (165, 90, 100, 25);
        labelCalificacion.setFont(new java.awt.Font("Arial",1,12));
        opCalificacion.setBounds (325, 90, 100, 25);
        opCalificacion.setFont(new java.awt.Font("Arial",1,12));
        textArea.setBounds (165, 140, 260, 105);
        textArea.setFont(new java.awt.Font("Arial",1,12));
        bExit.setBounds (325, 265, 100, 25);
        bExit.setFont(new java.awt.Font("Arial",1,12));

        //Paneles colores
        setBackground (new Color (150, 240, 75));
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == opCalificacion) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (opCalificacion.getSelectedItem().equals("vacio")) {
                    textArea.setText("");
                } else if (opCalificacion.getSelectedItem().equals("Muy buena")) {
                    textArea.setText("\n\n Gracias por tu ayuda!\n .El planeta te lo agradece.");
                } else if (opCalificacion.getSelectedItem().equals("Buena")) {
                    textArea.setText("\n\n Gracias por tu ayuda!\n .El planeta te lo agradece.");
                } else if (opCalificacion.getSelectedItem().equals("Regular")) {
                    textArea.setText("\n\n Gracias por tu ayuda!\n .El planeta te lo agradece.");
                } else if (opCalificacion.getSelectedItem().equals("Mala")) {
                    textArea.setText("\n\n Gracias por tu ayuda!\n .El planeta te lo agradece.");
                } else if (opCalificacion.getSelectedItem().equals("Muy mala")) {
                    textArea.setText("\n\n Gracias por tu ayuda!\n .El planeta te lo agradece.");
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bExit) {
            try{
                Persistencia.crearBasura();
            }
            catch(Exception f){}
            System.exit(0);
        }
    }
    public void Exit(){
        JFrame frame = new JFrame("Calificacion");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Salida());
        frame.pack();
        frame.setVisible (true);
    }

    public static String pedirCalificacion(){
        String calificacion = (String)opCalificacion.getSelectedItem();
        return calificacion;
    }
}
