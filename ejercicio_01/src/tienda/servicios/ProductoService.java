package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoService {

    private ProductoDAO dao;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre");
            }
            if (precio == 0) {
                throw new Exception("No puedes regalar el producto");
            }
            if (precio < 0) {
                throw new Exception("El precio debe indicar un valor positivo");
            }
            if (codigoFabricante <= 0) {
                throw new Exception("El codigo de fabricante debe indicar un valor positivo");
            }
            Producto p = new Producto();
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(codigoFabricante);
            dao.cargarProducto(p);
        } catch (Exception e) {
            throw e;
        }

    }

    public void modificarNombre(int codigo, String nombreNuevo) throws Exception {
        try {
            if (nombreNuevo == null) {
                throw new Exception("Debe indicar un nombre");
            }
            dao.modificarProductoPorNombre(codigo, nombreNuevo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarPrecio(int codigo, double precioNuevo) throws Exception {
        try {
            if (precioNuevo == 0) {
                throw new Exception("No puedes regalar el producto");
            }
            if (precioNuevo < 0) {
                throw new Exception("El precio debe indicar un valor positivo");
            }
            dao.modificarProductoPorPrecio(codigo, precioNuevo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarCodigoFabricante(int codigo, int codigoFabricanteNuevo) throws Exception {
        try {
            if (codigoFabricanteNuevo <= 0) {
                throw new Exception("El codigo de fabricante debe indicar un valor positivo");
            }
            dao.modificarProductoPorCodigoFabricante(codigo, codigoFabricanteNuevo);
        } catch (Exception e) {
            throw e;
        }
    }
}
