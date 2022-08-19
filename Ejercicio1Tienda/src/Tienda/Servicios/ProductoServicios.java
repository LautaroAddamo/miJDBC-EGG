package Tienda.Servicios;

import Tienda.Entidades.Producto;
import Tienda.Persistencia.ProductoDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ProductoServicios {

    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ProductoDAO dao;

    public ProductoServicios() {
        this.dao = new ProductoDAO();
    }

    public void insertarProducto() throws Exception {
        //Le pide al usuario los datos del producto a guardar
        try {
            System.out.println("Ingrese el nombre del producto");
            String nombre = leer.next();
            System.out.println("Ingrese el precio del producto");
            double precio = leer.nextDouble();
            System.out.println("Ingrese el codigo del fabricante");
            int codFab = leer.nextInt();
            insertarProducto(nombre, precio, codFab);//envia los datos al metodo que va a instanciar el objeto
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void insertarProducto(String nombre, double precio, int codFab) throws Exception {
        if (codFab >= 10 || 0 < codFab) {
            throw new Exception("El codigo de fabricante es invalido");
        }
        validar(nombre, precio);//valida los datos
        Producto producto = new Producto();//instancia el objeto
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCodigoFabricante(codFab);
        dao.insertarProducto(producto);//envia el pedido a la base de datos
    }

    public void modificarProducto() throws Exception {//Pide los datos del producto que quiere modificar
        System.out.println("Indique el codigo del producto a modificar");
        int cod = leer.nextInt();
        System.out.println("Indique el nuevo nombre del producto");
        String nombre = leer.next();
        System.out.println("Indique el nuevo precio del producto");
        double precio = leer.nextDouble();
        modificarProducto(cod, nombre, precio);//Envio los datos a otro metodo
    }

    public void modificarProducto(int cod, String nombre, double precio) throws Exception {
        //valida los parametros recibidos
        if (cod <= 0) {
            throw new Exception("El codigo es invalido");
        }
        validar(nombre, precio);
        //crea un producto para igualarlo a otro mediante una busqueda por codigo
        Producto productoModificado = buscarPorCodigo(cod);
        //aca el producto ya se modifico
        //envio el producto por parametro hacia el DAO
        dao.modificarProducto(productoModificado);
    }

    public Producto buscarPorCodigo(int cod) throws Exception {
        try {
            if (cod < 0) {
                throw new Exception("Codigo invalido");
            }
            //Creo el producto que me va a devolver la consulta SQL
            Producto productoModificado = dao.obtenerProductoPorCodigo(cod);
            if (productoModificado == null) {
                throw new Exception("El producto es invalido");
            }
            return productoModificado;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("Error de sistema");
        }
    }

    public void validar(String nombre, double precio) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre es invalido");
        }
        if (precio <= 0) {
            throw new Exception("El precio debe ser mayor que 0");
        }
    }

    public void listarProductos() throws Exception {
        Collection<Producto> listaProductos = dao.listarProductos();
        for (Producto listaProducto : listaProductos) {
            System.out.println(listaProducto);
        }
    }
    public void listarNombrePrecio() throws Exception {
        Collection<Producto> nombrePrecio = dao.nombresYPreciosProductos();
        for (Producto producto : nombrePrecio) {
            System.out.println("Nombre: " + producto.getNombre() + " .Precio: " + producto.getPrecio());
        }
    }
    public void productosEntre() throws Exception{
        Collection<Producto>productosEntre = dao.productosEntre();
        for (Producto producto : productosEntre) {
            System.out.println(producto);
        }
    }
    public void mostrarPortatiles() throws Exception{
        Collection<Producto>productosEntre = dao.mostrarPortatiles();
        for (Producto producto : productosEntre) {
            System.out.println(producto);
        }
    }

}
