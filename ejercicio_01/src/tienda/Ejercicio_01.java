package tienda;

import java.util.Scanner;
import tienda.persistencia.FabricanteDAO;
import tienda.persistencia.ProductoDAO;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;

public class Ejercicio_01 {

    public static void main(String[] args) throws Exception {
        System.out.println(5.5%1);
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductoService pService = new ProductoService();
        FabricanteService fService = new FabricanteService();
        ProductoDAO pDao = new ProductoDAO();
        FabricanteDAO fDao = new FabricanteDAO();
        int opcion;
        do {
            System.out.println("\tMenu ");
            System.out.println("1 - Listar nombre de los productos");
            System.out.println("2 - Listar nombre y precio de los productos");
            System.out.println("3 - Productos entre $120 y $202");
            System.out.println("4 - Listar portatiles");
            System.out.println("5 - Listar producto más barato");
            System.out.println("6 - Cargar un producto");
            System.out.println("7 - Cargar un fabricante");
            System.out.println("8 - Editar un producto");
            System.out.println("9 - Salir");
            System.out.println("Elija su opcion:");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    pDao.listarProductosPorNombre();
                    break;
                case 2:
                    pDao.listarProductosPorNombreYPrecio();
                    break;
                case 3:
                    pDao.listarProductosEntre();
                    break;
                case 4:
                    pDao.listarProductosPortatiles();
                    break;
                case 5:
                    pDao.listarProductoMasBarato();
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del producto");
                    String nombreP = leer.next();
                    System.out.println("Ingrese el precio del producto");
                    double precio = leer.nextDouble();
                    System.out.println("Ingrese el código del fabricante");
                    int codigoFabricante = leer.nextInt();
                    pService.crearProducto(nombreP, precio, codigoFabricante);
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del fabricante");
                    String nombreF = leer.next();
                    fService.crearFabricante(nombreF);
                    break;
                case 8:
                    pDao.listarProductos();
                    System.out.println("Ingrese el codigo del producto a modificar");
                    int codigo = leer.nextInt();
                    if (pDao.buscarProducto(codigo)) {
                        System.out.println("¿Qué campo desea modificar?");
                        System.out.println("1- Nombre");
                        System.out.println("2- Precio");
                        System.out.println("3- Código de Fabricante");
                        int opc2 = leer.nextInt();
                        switch (opc2) {
                            case 1:
                                System.out.println("Ingrese el nombre nuevo");
                                String nombreNuevo = leer.next();
                                pService.modificarNombre(codigo, nombreNuevo);
                                break;
                            case 2:
                                System.out.println("Ingrese el precio nuevo");
                                double precioNuevo = leer.nextDouble();
                                pService.modificarPrecio(codigo, precioNuevo);
                                break;
                            case 3:
                                System.out.println("Ingrese el código de fabricante nuevo");
                                int codigoFabricanteNuevo = leer.nextInt();
                                pService.modificarCodigoFabricante(codigo, codigoFabricanteNuevo);
                                break;
                            default:
                                System.out.println("Ingresaste una opción inválida");
                        }
                    }else{
                        System.out.println("Lo sentimos el codigo seleccionado no existe en los productos");
                    }
                    break;
                case 9:
                    System.out.println("Hasta Luego...");
                    break;
                default:
                    System.out.println("Esa no es una opcion valida, vuelva a intentar...");
                    break;
            }
        } while (opcion != 9);
    }

}
