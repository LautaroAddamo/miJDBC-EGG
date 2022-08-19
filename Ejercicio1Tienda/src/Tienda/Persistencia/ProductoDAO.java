package Tienda.Persistencia;

import Tienda.Entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

public final class ProductoDAO extends DAO {

    public void insertarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO Producto (nombre,precio,codigo_fabricante)" + "VALUES ( ' " + producto.getNombre() + " ' ,  " + producto.getPrecio() + " , " + producto.getCodigoFabricante() + " ) ; ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void modificarProducto(Producto productoModificado) throws Exception {
        try {
            if (productoModificado == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET " + "nombre = " + productoModificado.getNombre() + " precio = " + productoModificado.getPrecio() + " codigo_fabricante = " + productoModificado.getCodigoFabricante() + " WHERE codigo = " + productoModificado.getCodigo() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Collection<Producto> listarProductos() throws Exception {//Pide todo de todos los productos
        Collection<Producto> productos = new ArrayList();
        try {
            String sql = "SELECT * FROM Producto;";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.toString());

            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> nombresYPreciosProductos() throws Exception {//Pide nombre y precio de todos los productos
        try {
            String sql = "SELECT nombre, precio FROM producto;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            System.out.println(e.toString());
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Producto> productosEntre() throws Exception {//Pide todo de los productos cuyo precio esta entre 120 y 202
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getNString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            System.out.println(e.toString());

            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> mostrarPortatiles() throws Exception { //Busca y muestra solo las portatiles
        try {
            String sql = "SELECT * FROM Producto WHERE nombre LIKE %portatil%;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getNString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Producto productoMasBarato() throws Exception {//Pide nombre y precio del mas barato
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;";
            consultarBase(sql);
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

            }

            return producto;
        } catch (Exception e) {
            System.out.println(e.toString());

            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

    public Producto obtenerProductoPorCodigo(int cod) throws Exception {
        //setea los atributos del producto, mediante la consulta SQL
        //el parametro que se le envia es para que elija el producto que 
        //tiene el codigo recibido
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + cod + ";";
            consultarBase(sql);
            Producto productoModificado = new Producto();
            while (resultado.next()) {
                productoModificado.setCodigo(resultado.getInt(1));
                productoModificado.setNombre(resultado.getString(2));
                productoModificado.setPrecio(resultado.getDouble(3));
                productoModificado.setCodigoFabricante(resultado.getInt(4));
            }
            return productoModificado;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }

}
