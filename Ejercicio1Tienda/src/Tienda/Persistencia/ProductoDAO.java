
package Tienda.Persistencia;

import Tienda.Entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;


public final class ProductoDAO extends DAO {
    
    public void insertarProducto(Producto producto) throws Exception{
        try {
            if (producto == null) {
                throw new Exception ("Debe indicar un producto");
            }
            String sql = "INSERT INTO Producto (nombre,precio,codigo_fabricante)" + "VALUES ( ' " + producto.getNombre() + " ' ,  " + producto.getPrecio() + " , " + producto.getCodigoFabricante() + " ) ; ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void modificarProducto(Producto producto) throws Exception{
        try {
            if (producto == null) {
                throw new Exception ("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET " + "nombre = " + producto.getNombre() + " precio = " + producto.getPrecio() + " codigo_fabricante = " + producto.getCodigoFabricante() + " WHERE codigo = " + producto.getCodigo() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void eliminarProducto(int codigo) throws Exception{
        try {
            String sql = "DELETE FROM Producto WHERE codigo = " + codigo +";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public Collection<Producto> listarProductos() throws Exception{
        try {
            String sql = "SELECT * FROM Producto;";
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()) {                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
        }
    }
    
}
