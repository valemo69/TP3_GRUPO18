package entidad;

public class Producto {

	
	private String Codigo;
	private String Nombre;
	private double Precio;
	private int Stock;
	private int idCategoria;
	

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Producto() {}

	

	

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	@Override
	public String toString() {
		return Codigo + " | " + Nombre + " | $" + Precio + " | stock " + Stock + " | categoria " + idCategoria;
	}

}