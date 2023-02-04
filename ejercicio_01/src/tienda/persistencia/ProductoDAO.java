package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {

    public void listarProductosPorNombre() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto;";
            consultarBase(sql);
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                Producto p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                productos.add(p);
            }
            for (Producto n : productos) {
                System.out.println(n.getNombre());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProductosPorNombreYPrecio() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto;";
            consultarBase(sql);
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                Producto p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                productos.add(p);
            }
            for (Producto n : productos) {
                System.out.println(n.getNombre() + ", $" + n.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProductosEntre() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto where precio BETWEEN 120 AND 202;";
            consultarBase(sql);
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                Producto p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                productos.add(p);
            }
            for (Producto n : productos) {
                System.out.println(n.getNombre() + ", $" + n.getPrecio());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProductosPortatiles() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto WHERE nombre like '%Portatil%';";
            consultarBase(sql);
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                Producto p = new Producto();
                p.setNombre(resultado.getString("nombre"));
                productos.add(p);
            }
            for (Producto n : productos) {
                System.out.println(n.getNombre());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1;";
            consultarBase(sql);
            resultado.next();
            Producto p = new Producto();
            p.setNombre(resultado.getString("nombre"));
            p.setPrecio(resultado.getDouble("precio"));
            System.out.println(p.getNombre() + ", $" + p.getPrecio());

        } catch (Exception e) {
            throw e;
        }
    }

    public void cargarProducto(Producto p) {
        try {
            if (p == null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO producto(nombre,precio,codigo_fabricante)"
                    + "VALUES ('" + p.getNombre() + "'," + p.getPrecio() + ","
                    + p.getCodigoFabricante() + ");";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
        }
    }

    public void listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto;";
            consultarBase(sql);
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                Producto p = new Producto();
                p.setCodigo(resultado.getInt("codigo"));
                p.setNombre(resultado.getString("nombre"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
                productos.add(p);
            }
            for (Producto n : productos) {
                System.out.println(n.getCodigo() + " " + n.getNombre() + " "
                        + n.getPrecio() + " " + n.getCodigoFabricante());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean buscarProducto(int codigo) throws Exception {
        try {
            Producto p = new Producto();
            p.setCodigo(codigo);
            String sql = "SELECT count(codigo) as codigo FROM producto WHERE codigo = "
                    + p.getCodigo() + ";";
            consultarBase(sql);
            resultado.next();
            return resultado.getInt("codigo") != 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProductoPorNombre(int codigo, String nombre) throws Exception {
        try {
            String sql = "UPDATE producto SET nombre = '" + nombre + "' WHERE "
                    + "codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProductoPorPrecio(int codigo, Double precio) throws Exception {
        try {
            String sql = "UPDATE producto SET precio = " + precio + " WHERE "
                    + "codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProductoPorCodigoFabricante(int codigo, int codigoFabricante) throws Exception {
        try {
            String sql = "UPDATE producto SET codigo_fabricante = "
                    + codigoFabricante + " WHERE " + "codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
