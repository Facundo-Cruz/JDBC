package estancias.servicios;

import estancias.persistencia.DaoCasas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Guillote
 */
public class CasasServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    DaoCasas dao = new DaoCasas();

    public void opcionMenu4() throws Exception {
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.println("Ingrese una fecha (YYYY-MM-DD)");
            int year = leer.nextInt();
            int month = leer.nextInt();
            int day = leer.nextInt();
            Date date_desde = DateFor.parse(year + "-" + month + "-" + day);
            System.out.println("Date : " + date_desde);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_desde));
            System.out.println("Ingrese la cantidad de dias");
            int cant = leer.nextInt();
            Date date_hasta = DateFor.parse(year + "-" + month + "-" + (day + cant));
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_hasta));
            dao.vacacionesDesde(date_desde, date_hasta, cant);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
