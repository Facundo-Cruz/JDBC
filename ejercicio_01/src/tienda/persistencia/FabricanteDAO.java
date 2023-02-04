package tienda.persistencia;

import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public void cargarFabricante(Fabricante f) throws Exception {
        try {
            if (f == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "INSERT INTO fabricante(nombre) VALUES('" + f.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
