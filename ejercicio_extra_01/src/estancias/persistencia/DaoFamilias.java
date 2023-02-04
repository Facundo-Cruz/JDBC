package estancias.persistencia;

import estancias.entidades.Familias;
import java.util.ArrayList;
import java.util.List;

public class DaoFamilias extends DAO {

    //Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años
    public List<Familias> listarFamilias() throws Exception {

        try {
            String sql = "SELECT * FROM familias ";
            consultarBase(sql);
            Familias familia = null;
            List<Familias> family = new ArrayList();
            while (resultado.next()) {
                familia = new Familias();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa_familia(resultado.getInt(7));
                family.add(familia);
            }
            return family;
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }

}
