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

public class B1productoLineaGUI extends JFrame implements ActionListener {
    private JButton bConsultar, bConsultarProducto;
    private JTextField tfClaveLinea, tfClaveProducto;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private CompanyADjdbc companyad = new CompanyADjdbc();

    public B1productoLineaGUI() {
        super("Asignacion de Proveedor");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfClaveLinea = new JTextField();
        tfClaveProducto = new JTextField();
        bConsultar = new JButton("Consulta General de productos");
        bConsultarProducto = new JButton("Consultar producto");

        // Adicionar addActionListener a lo JButtons
        bConsultar.addActionListener(this);
        bConsultarProducto.addActionListener(this);

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clave de linea: "));
        panel1.add(tfClaveLinea);
        panel1.add(new JLabel("Clave del producto: "));
        panel1.add(tfClaveProducto);

        panel1.add(bConsultar);
        panel1.add(bConsultarProducto);

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

    public int obtenerDatos(){
        String num  = tfClaveLinea.getText();
        int linea = 0;
        //String cla  = tfClaveProducto.getText();
        
        if(num.isEmpty())
            linea = -1;
        else {
            //int cla1 = 0;
            try { 
                //por si no hay un valor numerico
                linea = Integer.parseInt(num);
                //cla1   = Integer.parseInt(cla);
            } 
            catch (NumberFormatException nfe) {
                linea = -2;
            }  } 
        return linea;
    }

     public void actionPerformed(ActionEvent e) {
        String datos = "";
        
        String resultado = "";

        if (e.getSource() == bConsultar) {
            int linea = obtenerDatos();
            //System.out.println("linea ="+linea);
            if(linea == -1){
                datos = "Datos vacios";
            }
            else if(linea == -2)
                   datos = "Ingrese el NUMERO de linea";
            
            resultado = companyad.consultarLineaProd(linea);
            System.out.println("En GUI: "+datos);
            taDatos.setText(datos); 
        }
        if (e.getSource() == bConsultarProducto) {
            datos = companyad.consultarProducto();
            if(datos.isEmpty()){
                datos = "Datos vacios";                
            }
            taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new B1productoLineaGUI();
    }
}