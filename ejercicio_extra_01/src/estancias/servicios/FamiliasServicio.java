package estancias.servicios;

import estancias.entidades.Familias;
import estancias.persistencia.DAO;
import estancias.persistencia.DaoFamilias;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Guillote
 */
public class FamiliasServicio extends DAO {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    DaoFamilias dfs = new DaoFamilias();

    public void opcionMenu1() throws Exception {
        try {
            System.out.println("\t--Familias con 3 hijos o más menores de 10 años--");
            for (Familias aux : dfs.listarFamilias()) {

                if (aux.getEdad_maxima() < 10 && aux.getNum_hijos() >= 3) {
                    System.out.println(aux.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

    
    public void opcionMenu3() throws Exception {
        try {

            for (Familias aux : dfs.listarFamilias()) {

                if (aux.getEmail().contains("hotmail")) {
                    System.out.println(aux.getEmail());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

    

}
