package Tienda;

import Tienda.Servicios.ProductoServicios;

public class Main {

    public static void main(String[] args) throws Exception {
        ProductoServicios ps = new ProductoServicios();

        ps.listarProductos();

        int opc = 1;
        switch (opc) {
            case 1:
                break;
            case 2:
                break;
        }
    }

}
