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
    LineaDP lineaDP;
    ProductoDP productoDP = new ProductoDP();;
    TieneDP tieneDP;
    SuministraDP suministraDP;
    LocalidadDP localidadDP;
    
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
    String AltaLinea(String datos) 
    {
		String resultado = "";
		String insert="";

		lineaDP = new LineaDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO linea VALUES("+lineaDP.toStringSql()+")";
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
    String consultarLinea() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM linea";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        lineaDP=new LineaDP();
                        while(sr.next())
                        {

                        lineaDP.setclaveLinea(sr.getInt(1));	
                        lineaDP.setNombre(sr.getString(2));	
                        lineaDP.setDescripcion(sr.getString(3));		

                        datos=datos+lineaDP.toString()+"\n";
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
    
    String AltaProductos(String datos) 
    {
		String resultado = "";
		String insert="";

		productoDP = new ProductoDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO Producto VALUES("+productoDP.toStringSql()+")";
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
    
    String consultarProducto() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM producto";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        productoDP=new ProductoDP();
                        while(sr.next())
                        {

                        productoDP.setclaveProducto(sr.getInt(1));	
                        productoDP.setNombre(sr.getString(2));	
                        productoDP.setMarca(sr.getString(3));
                        productoDP.setcantidadExistente(sr.getInt(4));
                        productoDP.setprecioUnitario(sr.getInt(5));
                        productoDP.setclaveLinea(sr.getInt(6));

                        datos=datos+productoDP.toString()+"\n";
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
    
    String AltaTiene(String datos) 
    {
		String resultado = "";
		String insert="";

		tieneDP = new TieneDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO Tiene VALUES("+tieneDP.toStringSql()+")";
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
			resultado = "(Ingresa otro)";	
		}
		return resultado;	
	}
    
    String consultarTiene() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM tiene";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        tieneDP=new TieneDP();
                        while(sr.next())
                        {

                        tieneDP.setNumeroSucursal(sr.getInt(1));	
                        tieneDP.setClaveProducto(sr.getInt(2));	
                      

                        datos=datos+tieneDP.toString()+"\n";
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
    
    String altaSuministra(String datos) 
    {
		String resultado = "";
		String insert="";
                String insert2;

		suministraDP = new SuministraDP(datos);
                //productoDP = new ProductoDP();
                int newCantidad = suministraDP.getCantidad() + productoDP.getcantidadExistente();
                int clave = suministraDP.getClaveProducto();
                System.out.println("Cantidad anterior: "+ (newCantidad - suministraDP.getCantidad()) + "\n Nueva Cantidad: "+newCantidad);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO Suministra VALUES("+suministraDP.toStringSql()+")";
                insert2="UPDATE producto SET cantidad = "+newCantidad+" WHERE claveProducto = "+ clave ;
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
                        statement.executeUpdate(insert2);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "(Ingresa otro)";	
		}
		return resultado;	
	}
    String consultarSuminstra() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM suministra";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        suministraDP=new SuministraDP();
                        while(sr.next())
                        {

                        suministraDP.setClaveProducto(sr.getInt(1));
                        suministraDP.setClaveProveedor(sr.getInt(2));
                        suministraDP.setfecha(sr.getString(3));
                        suministraDP.setCantidad(sr.getInt(4));	
                      

                        datos=datos+suministraDP.toString()+"\n";
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
    
    String altaLocalidad(String datos) 
    {
		String resultado = "";
		String insert="";

		localidadDP = new LocalidadDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO localidad VALUES("+localidadDP.toStringSql()+")";
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
			resultado = "(Ingresa otro)";	
		}
		return resultado;	
	}
    
    String consultarLocalidad() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM localidad";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        localidadDP=new LocalidadDP();
                        while(sr.next())
                        {
                        localidadDP.setEstado(sr.getString(1));
                        localidadDP.setColonia(sr.getString(2));
                        localidadDP.setCalle(sr.getString(3));
                        localidadDP.setNumero(sr.getInt(4));	
                        localidadDP.setCp(sr.getInt(5));
                        localidadDP.setTelefono(sr.getInt(6));
                        localidadDP.setClaveSucursal(sr.getInt(7));

                        datos=datos+localidadDP.toString()+"\n";
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
    
    String consultarLineaProd(int clave) {
        String datos = "";
        String respuesta = "";
         ResultSet tr;
        
        String query = "SELECT Linea.nombre, Producto.claveProducto FROM Producto JOIN Linea ON Producto.claveLin = Linea.claveLinea WHERE claveLinea = "+clave+"";
        System.out.println(query);
        
        try{
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            
            while(tr.next()){
                datos = tr.getString(1);
                    //datos = datos+"_"+tr.getString(i);
                    //int aStr = ""+tr.getInt(i);
                    
                respuesta = respuesta + datos+"\n";
                //System.out.println(datos);
            } 
            statement.close();
            //System.out.println("\nAD: "+datos);
        }catch(SQLException sqle){
            respuesta = "Error consultar cliente "+sqle;
        }
        return respuesta;
    }
}
