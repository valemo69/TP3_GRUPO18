package dao;
import entidad.Categoria;
import entidad.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import entidad.Producto;

public class DaoProducto {

	private String host ="jdbc:mysql://localhost:3306/"; 
    private String user ="root"; 
    private String pass ="root"; 
	private String dbName="bdinventario"; 


	public DaoProducto() {
		
	
		
	}

	public int agregarProducto(Producto producto) {
		String query = "CALL sp_AgregarProducto('"
	            + producto.getCodigo() + "', '"
	            + producto.getNombre() + "', "
	            + producto.getPrecio() + ", "
	            + producto.getStock() + ", "
	            + producto.getIdCategoria() + ")";
		
		Connection cn=null; 
		int verificador=0;
		
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass); 
		    Statement st=cn.createStatement();
			verificador=st.executeUpdate(query);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	return verificador;
	}
	
	public Producto ObtenerProducto(String codigo) {

		Producto x = new Producto();
		Connection cn = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM Productos WHERE Codigo = '" + codigo + "'";
			ResultSet set = st.executeQuery(query);

			if (set.next()) {
				x.setCodigo(set.getString("Codigo"));
				x.setNombre(set.getString("Nombre"));
				x.setPrecio(set.getDouble("Precio"));
				x.setStock(set.getInt("Stock"));
				x.setIdCategoria(set.getInt("IdCategoria"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return x;
	}
	
	public ArrayList<Producto> ObtenerProductos() {

		ArrayList<Producto> LProductos = new ArrayList<Producto>();
		Connection cn = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM Productos";
			ResultSet set = st.executeQuery(query);

			while (set.next()) {
				Producto x = new Producto();

				x.setCodigo(set.getString("Codigo"));
				x.setNombre(set.getString("Nombre"));
				x.setPrecio(set.getDouble("Precio"));
				x.setStock(set.getInt("Stock"));
				x.setIdCategoria(set.getInt("IdCategoria"));

				LProductos.add(x);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return LProductos;
	}
}	

