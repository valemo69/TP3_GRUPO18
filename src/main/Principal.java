package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

    public static void main(String[] args) {

        DaoCategoria daoCat = new DaoCategoria();
        DaoProducto daoProd = new DaoProducto();

        // 1. Alta de 2 Categorías iniciales (para respetar la clave foránea)
        System.out.println("--- REGISTRANDO CATEGORÍAS ---");
        Categoria cat1 = new Categoria();
        cat1.setNombre("Periféricos");
        // No le seteamos ID porque en MySQL Categorias es AUTO_INCREMENT

        Categoria cat2 = new Categoria();
        cat2.setNombre("Mobiliario");

        int altaCat1 = daoCat.agregarCategoria(cat1);
        int altaCat2 = daoCat.agregarCategoria(cat2);

        if (altaCat1 > 0) System.out.println("Categoría 'Periféricos' agregada.");
        if (altaCat2 > 0) System.out.println("Categoría 'Mobiliario' agregada.");

        // 2. Alta de 10 productos usando sp_AgregarProducto
        System.out.println("\n--- REGISTRANDO PRODUCTOS ---");
        
        // Creamos una lista para iterar y cargar más prolijo
        Producto[] listaAltas = new Producto[10];

        // Producto 1
        listaAltas[0] = new Producto();
        listaAltas[0].setCodigo("P001");
        listaAltas[0].setNombre("Teclado Mecánico RGB");
        listaAltas[0].setPrecio(45000.0);
        listaAltas[0].setStock(15);
        listaAltas[0].setIdCategoria(1); // Asumimos que "Periféricos" tomó el ID 1

        // Producto 2
        listaAltas[1] = new Producto();
        listaAltas[1].setCodigo("P002");
        listaAltas[1].setNombre("Mouse Óptico Gamer");
        listaAltas[1].setPrecio(25000.0);
        listaAltas[1].setStock(30);
        listaAltas[1].setIdCategoria(1);

        // Producto 3
        listaAltas[2] = new Producto();
        listaAltas[2].setCodigo("P003");
        listaAltas[2].setNombre("Monitor 24 Pulgadas FHD");
        listaAltas[2].setPrecio(180000.0);
        listaAltas[2].setStock(10);
        listaAltas[2].setIdCategoria(1);

        // Producto 4
        listaAltas[3] = new Producto();
        listaAltas[3].setCodigo("P004");
        listaAltas[3].setNombre("Auriculares Inalámbricos");
        listaAltas[3].setPrecio(55000.0);
        listaAltas[3].setStock(20);
        listaAltas[3].setIdCategoria(1);

        // Producto 5
        listaAltas[4] = new Producto();
        listaAltas[4].setCodigo("P005");
        listaAltas[4].setNombre("Webcam 1080p HD");
        listaAltas[4].setPrecio(38000.0);
        listaAltas[4].setStock(12);
        listaAltas[4].setIdCategoria(1);

        // Producto 6
        listaAltas[5] = new Producto();
        listaAltas[5].setCodigo("P006");
        listaAltas[5].setNombre("Silla Ergonómica");
        listaAltas[5].setPrecio(220000.0);
        listaAltas[5].setStock(8);
        listaAltas[5].setIdCategoria(2); // Asumimos que "Mobiliario" tomó el ID 2

        // Producto 7
        listaAltas[6] = new Producto();
        listaAltas[6].setCodigo("P007");
        listaAltas[6].setNombre("Escritorio Regulable");
        listaAltas[6].setPrecio(310000.0);
        listaAltas[6].setStock(5);
        listaAltas[6].setIdCategoria(2);

        // Producto 8
        listaAltas[7] = new Producto();
        listaAltas[7].setCodigo("P008");
        listaAltas[7].setNombre("Soporte para Monitor");
        listaAltas[7].setPrecio(28000.0);
        listaAltas[7].setStock(18);
        listaAltas[7].setIdCategoria(2);

        // Producto 9
        listaAltas[8] = new Producto();
        listaAltas[8].setCodigo("P009");
        listaAltas[8].setNombre("Lámpara de Escritorio LED");
        listaAltas[8].setPrecio(21000.0);
        listaAltas[8].setStock(25);
        listaAltas[8].setIdCategoria(2);
        
        // Producto 10
        listaAltas[9] = new Producto();
        listaAltas[9].setCodigo("P010");
        listaAltas[9].setNombre("Pad Mouse XXL");
        listaAltas[9].setPrecio(15000.0);
        listaAltas[9].setStock(50);
        listaAltas[9].setIdCategoria(1);

        // Ejecutamos las inserciones
        for (Producto p : listaAltas) {
            int filas = daoProd.agregarProducto(p);
            if (filas > 0) {
                System.out.println("Guardado exitoso: " + p.getNombre() + " (" + p.getCodigo() + ")");
            } else {
                System.out.println("Error al guardar: " + p.getCodigo());
            }
        }

        // 3. Listado para verificar que impactaron en la base
        System.out.println("\n--- LISTADO DE PRODUCTOS DESDE BD ---");
        ArrayList<Producto> productosBD = daoProd.ObtenerProductos();
        
        for (Producto p : productosBD) {
            System.out.println("Cód: " + p.getCodigo() + " - " + p.getNombre() + " | Precio: $" + p.getPrecio() + " | Stock: " + p.getStock() + " | IdCat: " + p.getIdCategoria());
        }
    }
}