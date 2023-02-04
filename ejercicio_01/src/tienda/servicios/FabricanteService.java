package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteService {
    private FabricanteDAO dao;

    public FabricanteService() {
        dao = new FabricanteDAO();
    }
    public void crearFabricante(String Nombre) throws Exception{
        try {
            if (Nombre == null) {
                throw new Exception("Debe indicar el nombre");
            }
            Fabricante f = new Fabricante();
            f.setNombre(Nombre);
            dao.cargarFabricante(f);
        } catch (Exception e) {
            throw e;
        }
        
    }
}
