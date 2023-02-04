package estancias.persistencia;

import estancias.entidades.Casas;
import estancias.entidades.Clientes;
import java.util.ArrayList;
import java.util.List;

public final class DaoClientes extends DAO {

    public void mostrarClientesConComentarios() throws Exception {
        try {
            String sql = "select c.*, co.comentario from clientes c inner join "
                    + "estancias e on c.id_cliente = e.id_cliente"
                    + " inner join casas ca on e.id_casa = ca.id_casa"
                    + " inner join comentarios co on ca.id_casa = co.id_casa;";
            consultarBase(sql);
            Clientes cliente = null;
            List<Clientes> clientruchos = new ArrayList();
            while (resultado.next()) {
                cliente = new Clientes();
                cliente.setId_cliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString("comentario"));
                clientruchos.add(cliente);
            }
            for (Clientes aux : clientruchos) {
                System.out.println(aux.getId_cliente() + " " + aux.getNombre() + " " + aux.getCalle());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
}
