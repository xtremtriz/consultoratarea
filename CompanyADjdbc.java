/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Uriel
 */
public class CompanyADjdbc {
    SucursalDP sucursalDP;
    ProveedorDP proveedorDP;
    
    Connection conexion;
    Statement statement;
    public CompanyADjdbc()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultora?user=root");
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
    String AltaSucursal(String datos) 
    {
		String resultado = "";
		String insert="";

		sucursalDP = new SucursalDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO sucursal VALUES("+sucursalDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Este numero de sucursal ya existe, (Ingresa otro)";	
		}
		return resultado;	
	}

    String consultarSucursales() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM sucursal";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        sucursalDP=new SucursalDP();
                        while(sr.next())
                        {

                        sucursalDP.setnumSucursal(sr.getInt(1));	
                        sucursalDP.setNombre(sr.getString(2));	
                        sucursalDP.setDireccion(sr.getString(3));	
                        sucursalDP.setTelefono(sr.getInt(4));	

                        datos=datos+sucursalDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
        String AltaProveedor(String datos) 
    {
		String resultado = "";
		String insert="";

		proveedorDP = new ProveedorDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO proveedor VALUES("+proveedorDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Este numero de sucursal ya existe, (Ingresa otro)";	
		}
		return resultado;	
	}
        
        String consultarProveedor() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM proveedor";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        proveedorDP=new ProveedorDP();
                        while(sr.next())
                        {

                        proveedorDP.setclaveProveedor(sr.getInt(1));	
                        proveedorDP.setNombre(sr.getString(2));	
                        proveedorDP.setDireccion(sr.getString(3));	
                        proveedorDP.setTelefono(sr.getInt(4));	

                        datos=datos+proveedorDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
}
