package main;


import dao.DaoProducto;
import dao.DaoCategoria;
import entidad.Producto;
import entidad.Categoria;


public class Prinicpal {

	public static void main(String[] args) {
		
		DaoProducto dao = new DaoProducto();
		
	
		
		System.out.println(dao.ObtenerProductos());

		
		
		
		
	}

}
