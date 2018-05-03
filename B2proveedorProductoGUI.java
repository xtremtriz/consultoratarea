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

public class B2proveedorProductoGUI extends JFrame implements ActionListener {
    private JButton bConsultar;
    private JTextField tfClaveProveedor;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private CompanyADjdbc companyad = new CompanyADjdbc();

    public B2proveedorProductoGUI() {
        super("Consulta de productos");
        panel1 = new JPanel();
        panel2 = new JPanel();

        tfClaveProveedor = new JTextField();
        taDatos = new JTextArea(7, 35);//1-3
        bConsultar = new JButton("Consultar productos");

        // Adicionar addActionListener a lo JButtons
        bConsultar.addActionListener(this);

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clave de Proveedor"));
        panel1.add(tfClaveProveedor);

        panel1.add(bConsultar);

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
        int datos = 0;
        
        if(tfClaveProveedor.getText().isEmpty())
            datos = -1;
        else {
            try{
                datos = Integer.parseInt(tfClaveProveedor.getText());
            }catch(NumberFormatException nfe){
                datos = -2;
                System.out.println("Error al convertir el numero");
            }
        } 
        // System.out.println("\n "+datos);
        return datos;
    }

    public void actionPerformed(ActionEvent e) {
        String datos = "";
        int clave = 0;

        if (e.getSource() == bConsultar) {
            //datos = companyad.consultaAsignacionEmpleadosProyecto();
            clave = obtenerDatos();
            if(clave == -1)
                datos = "Ingrese la clave del proveedor";
            else if(clave == -2)
                datos = "La clave del proveedor debe ser numerica";
            else
                datos = companyad.consultarProveedorProducto(clave);

            taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new B2proveedorProductoGUI();
    }
}
