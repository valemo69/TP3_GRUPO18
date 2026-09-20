package dao;

import entidad.Categoria;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class DaoCategoria {
	
	private String host ="jdbc:mysql://localhost:3306/"; 
    private String user ="root"; 
	private String pass ="root"; 
	private String dbName="bdinventario"; 


	public DaoCategoria() {
		
		
		
	}

	public int agregarCategoria(Categoria categoria) {
		String query="Insert into categorias (Nombre) values ('"+categoria.getNombre()+"')";
		
		Connection cn=null; 
		int verificador=0;
		
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass); 
		    Statement st=cn.createStatement();
			verificador=st.executeUpdate(query);
			
			
		}catch(Exception e) {
			e.printStackTrace();//muestra el error por consola
		}
	
	
	return verificador;
	}



public int modificarCategoria(Categoria categoria) {
	String query = "UPDATE categorias SET Nombre = '"+categoria.getNombre()+"' WHERE Id ='"+categoria.getNombre() + "')";
	Connection cn=null; 
	int verificador=0; 
	
	try {
		cn=DriverManager.getConnection(host+dbName,user,pass); 
	    Statement st=cn.createStatement();//consulta
		verificador=st.executeUpdate(query); //ejecucion
	
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	
	return verificador;
	
}


public int EliminarCategoria(Categoria categoria) {
	String query = "DELETE FROM categorias WHERE Id = " + categoria.getIdCategoria();
	Connection cn=null; 
	int verificador=0; //ver cntidad de filas afectadas
	
	try {
		cn=DriverManager.getConnection(host+dbName,user,pass); 
	    Statement st=cn.createStatement();
		verificador=st.executeUpdate(query); 
	
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	
	return verificador;
}
	




	
}










