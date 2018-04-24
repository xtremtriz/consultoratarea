/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Uriel
 */
public class CompanyADjdbc {
    SucursalDP sucursalDP;
    
    Connection conexion;
    Statement statement;
    public CompanyADjdbc()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/company?user=root");
			System.out.println("Conexion exitosa...");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe);// if No driver
		}
		catch(InstantiationException ie)
		{
			System.out.println("Error 2: "+ie); // for newInstance
		}
		catch(IllegalAccessException iae)
		{
			System.out.println("Error 3: "+iae); // for newInstance
		}
		catch(SQLException sqle)
		{
			System.out.println("Error 4: "+sqle); // for newInstance

		}
	}
    String AltaSeguro(String datos) 
    {
		String resultado = "";
		String insert="";

		sucursalDP = new SucursalDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO accidente VALUES("+sucursalDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correctisima";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Algun campo esta mal";	
		}
		return resultado;	
	}
}
