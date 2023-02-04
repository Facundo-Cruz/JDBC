package estancias.persistencia;

import estancias.entidades.Casas;
import java.util.ArrayList;
import java.util.List;

public final class DaoEstancias extends DAO {
    
    public void mostrarEstanciasReservadasPorUnCliente() throws Exception {
        try {
            String sql = "SELECT e.id_estancia, c.nombre, c.pais, c.ciudad, ca.id_casa "
                    + "FROM estancias e INNER JOIN clientes c ON e.id_cliente = c.id_cliente "
                    + "INNER JOIN casas ca ON e.id_casa = ca.id_casa;;";
            consultarBase(sql);
            
            while (resultado.next()) {
                System.out.println(resultado.getInt(1) + " " + resultado.getString(2) + " " + resultado.getString(3) + " " + resultado.getString(4) + " " + resultado.getInt(5));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
}
