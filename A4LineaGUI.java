/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultora;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Uriel_fabs
 */

public class A4LineaGUI extends JFrame implements ActionListener {
    private JButton bConsultar, bCapturar;
    private JTextField tfClaveLinea, tfNombre, tfDescripcion;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    //private CompanyADjdbc companyad = new CompanyADjdbc();

    public A4LineaGUI() {
        super("Asignacion de Proveedor");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfClaveLinea = new JTextField();
        tfNombre = new JTextField();
        tfDescripcion = new JTextField();
        bCapturar = new JButton("Capturar datos");
        bConsultar = new JButton("Consulta General");

        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);;

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clave de linea: "));
        panel1.add(tfClaveLinea);
        panel1.add(new JLabel("Nombre de linea: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Descripcion: "));
        panel1.add(tfDescripcion);
        
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        // panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));

        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel getPanel2() {
        return this.panel2;
    }

    public String obtenerDatos(){
        String datos = "";
        String clave  = tfClaveLinea.getText();
        String nombr  = tfNombre.getText();
        String des   = tfDescripcion.getText();
        
        if(clave.isEmpty() || nombr.isEmpty() || des.isEmpty())
            datos = "VACIO";
        else {
            int cla = 0;            
            try { 
                //por si no hay un valor no numerico
                cla = Integer.parseInt(clave);
            } 
            catch (NumberFormatException nfe) {
                datos = "NO_NUMERICO";
            }   
            if (datos!="NO_NUMERICO")
                datos = cla+"_"+nombr+"_"+des;
        }
        return datos;
    }

    public void actionPerformed(ActionEvent e) {
        String datos = "";
        if (e.getSource() == bCapturar) {
            
        }

        if (e.getSource() == bConsultar) {
            //datos = companyad.consultaAsignacionEmpleadosProyecto();
            if(datos.isEmpty()){
                datos = "Datos vacios";
            }
            taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new A4LineaGUI();
    }
}
