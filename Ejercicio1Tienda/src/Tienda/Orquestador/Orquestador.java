
package Tienda.Orquestador;


public class Orquestador {
  

    public static void menu() {
        System.out.println("MENU"
                + "\n1. PRODUCTOS"
                + "\n2. FABRICANTES"
                + "\n3. SALIR");
    }
    public static void menuProductos(){
        System.out.println("Menu de productos"
                + "\n1. LISTA LOS NOMBRES DE TODOS LOS PRODUCTOS DE LA TABLA"
                + "\n2. LISTA NOMBRES Y PRECIOS DE TODOS LOS PRODUCTOS DE LA TABLA"
                + "\n3. LISTA PRODUCTOS ENTRE $120 Y $202"
                + "\n4. LISTA SOLO LOS PORTATILES DE LA TABLA"
                + "\n5. PRODUCTO MAS BARATO"
                + "\n6. INGRESAR UN NUEVO PRODUCTO"
                + "\n7. EDITAR UN PRODUCTO"
                + "\n8. MENU PRINCIPAL");
    }
    public void menuFabricantes(){
        System.out.println("Menu de fabricantes"
                + "\n1. INGRESAR NUEVO FABRICANTE"
                + "\n2. MOSTRAR FABRICANTES"
                + "\n3. MENU PRINCIPAL");
    }

}
