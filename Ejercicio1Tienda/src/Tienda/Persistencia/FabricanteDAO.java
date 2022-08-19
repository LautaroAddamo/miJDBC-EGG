package Tienda.Persistencia;

import Tienda.Entidades.Fabricante;
import Tienda.Entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

public final class FabricanteDAO extends DAO {

    public void insertarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "INSERT INTO Fabricante (nombre)" + "VALUES ( ' " + fabricante.getNombre() + " ' ) ; ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar que fabricante desea modificar");
            }
            String sql = "UPDATE Producto SET " + "nombre = " + fabricante.getNombre() + " WHERE codigo = " + fabricante.getCodigo() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Fabricante WHERE codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante;";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }    
            return fabricantes;
        } catch (Exception e) {
            System.out.println(e.toString());

            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }

    }
}
