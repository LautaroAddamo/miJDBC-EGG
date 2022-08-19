package Tienda.Orquestador;

import Tienda.Servicios.FabricanteServicios;
import Tienda.Servicios.ProductoServicios;
import java.util.Scanner;

public class Orquestador {

    private final static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void crearOrquestador() throws Exception {

        menuPrincipal();

    }

    public static void menuPrin() throws Exception {
        System.out.println("MENU"
                + "\n1. PRODUCTOS"
                + "\n2. FABRICANTES"
                + "\n3. SALIR");
    }

    public static void menuPrincipal() throws Exception {
        int opc;
        menuPrin();
        do {
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    menuProductos();
                    break;
                case 2:
                    menuFabricante();
                    break;
                case 3:
                    System.out.println("Ha salido del sistema tienda");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opc != 3);
    }

    public static void menuProd() throws Exception {
        System.out.println("Menu de productos"
                + "\n1. LISTA LOS NOMBRES DE TODOS LOS PRODUCTOS DE LA TABLA"
                + "\n2. LISTA NOMBRES Y PRECIOS DE TODOS LOS PRODUCTOS DE LA TABLA"
                + "\n3. LISTA PRODUCTOS ENTRE $120 Y $202"
                + "\n4. LISTA SOLO LOS PORTATILES DE LA TABLA"
                + "\n5. PRODUCTO MAS BARATO"
                + "\n6. INGRESAR UN NUEVO PRODUCTO"
                + "\n7. EDITAR UN PRODUCTO"
                + "\n8. ELIMINAR UN PRODUCTO"
                + "\n9. REPETIR MENU"
                + "\n10. MENU PRINCIPAL");

    }

    public static void menuProductos() throws Exception {
        ProductoServicios ps = new ProductoServicios();
        int opc;
        menuProd();
        do {
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    ps.listarProductos();
                    break;
                case 2:
                    ps.listarNombrePrecio();
                    break;
                case 3:
                    ps.productosEntre();
                    break;
                case 4:
                    ps.mostrarPortatiles();
                    break;
                case 5:
                    ps.mostrarMasbarato();
                    break;
                case 6:
                    ps.insertarProducto();
                    break;
                case 7:
                    ps.modificarProducto();
                    break;
                case 8:
                    ps.eliminarProducto();
                    break;
                case 9:
                    menuProd();
                    break;
                case 10:
                    menuPrincipal();
                    break;
                default:

            }
        } while (opc != 10);

    }

    public static void menuFab() throws Exception {
        System.out.println("Menu de fabricantes"
                + "\n1. INGRESAR NUEVO FABRICANTE"
                + "\n2. MOSTRAR FABRICANTES"
                + "\n3. ELIMINAR UN FABRICANTE"
                + "\n4. REPETIR MENU"
                + "\n5. MENU PRINCIPAL");

    }

    public static void menuFabricante() throws Exception {
        FabricanteServicios fs = new FabricanteServicios();
        int opc;
        menuFab();
        do {
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    fs.insertarFabricante();
                    break;
                case 2:
                    fs.listarFabricantes();
                    break;
                case 3:
                    fs.eliminarFabricante();
                    break;
                case 4:
                    menuFab();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:

            }
        } while (opc
                != 5);
    }

}
