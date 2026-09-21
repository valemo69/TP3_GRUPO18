package dao;

import entidad.Categoria;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




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
			cn=DriverManager.getConnection(host+dbName,user,pass); //vinculo a la bd
		    Statement st=cn.createStatement();//carga de consulta
			verificador=st.executeUpdate(query);//ejecuta la consulta
			
			
		}catch(Exception e) {
			e.printStackTrace();//muestra el error por consola
		}
	
	
	return verificador;//cantidad de filas afectadas
	}



	public int modificarCategoria(Categoria categoria) {
		String query = "UPDATE categorias SET Nombre = '" + categoria.getNombre() + "' WHERE IdCategoria = " + categoria.getIdCategoria();
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
		String query = "DELETE FROM categorias WHERE IdCategoria = " + categoria.getIdCategoria();
		Connection cn=null; 
		int verificador=0; //ver cantidad de filas afectadas
		
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass); 
		    Statement st=cn.createStatement();
			verificador=st.executeUpdate(query); 
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return verificador;
	}
	
	public ArrayList<Categoria> ObtenerCategorias() {
	    ArrayList<Categoria> lista = new ArrayList<Categoria>();
	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = cn.createStatement();
	        String query = "SELECT * FROM Categorias";
	        ResultSet set = st.executeQuery(query);

	        while (set.next()) {
	            Categoria c = new Categoria();
	            c.setIdCategoria(set.getInt("IdCategoria"));
	            c.setNombre(set.getString("Nombre"));
	            lista.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return lista;
	}
}










