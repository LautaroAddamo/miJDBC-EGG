package Tienda.Servicios;

import Tienda.Entidades.Fabricante;
import Tienda.Persistencia.FabricanteDAO;
import java.util.Collection;
import java.util.Scanner;

public class FabricanteServicios {

    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private FabricanteDAO dao;

    public FabricanteServicios() {
        this.dao = new FabricanteDAO();
    }

    public void insertarFabricante() throws Exception {
        try {
            System.out.println("Ingrese el nombre del nuevo fabricante");
            String nombre = leer.next();
            insertarFabricante(nombre);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void insertarFabricante(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre es invalido");
        }
        Fabricante nuevoFabricante = new Fabricante();
        nuevoFabricante.setNombre(nombre);
        dao.insertarFabricante(nuevoFabricante);
    }

    public void listarFabricantes() throws Exception {
        Collection<Fabricante> fabricantes = dao.listarFabricantes();
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante);
        }
    }

    public void eliminarFabricante() throws Exception {
        System.out.println("Ingrese el codigo del fabricante que desea eliminar");
        int codigo = leer.nextInt();
        eliminarFabricante(codigo);
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            if (codigo < 0) {
                throw new Exception("Codigo invalido");
            }
            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
