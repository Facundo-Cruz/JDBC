/*
a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.
e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior
g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
h) Obtener el número de casas que existen para cada uno de los países diferentes.
i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
 */
package estancias;

import estancias.persistencia.DaoCasas;
import estancias.persistencia.DaoClientes;
import estancias.persistencia.DaoEstancias;
import estancias.servicios.CasasServicio;
import estancias.servicios.FamiliasServicio;
import java.util.Scanner;

public class Estancias {

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        FamiliasServicio fs = new FamiliasServicio();
        CasasServicio cs = new CasasServicio();
        DaoCasas daoC = new DaoCasas();
        DaoClientes daoCl = new DaoClientes();
        DaoEstancias daoE = new DaoEstancias();

        int opc = 0;
        do {
            System.out.println("-------- ELIGE LA OPCION-------");
            System.out.println("1- Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
            System.out.println("2- Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de\n"
                    + "2020 y el 31 de agosto de 2020 en Reino Unido.");
            System.out.println("3- Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.");
            System.out.println("4- Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada\n"
                    + "y un número de días específico.");
            System.out.println("5-Listar los datos de todos los clientes que en algún momento realizaron una estancia y la\n"
                    + "descripción de la casa donde la realizaron.");
            System.out.println("6-Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y\n"
                    + "ciudad del cliente y además la información de la casa que reservó.");
            System.out.println("7-Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el\n"
                    + "precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios\n"
                    + "actualizados.");
            System.out.println("8-Obtener el número de casas que existen para cada uno de los países diferentes.");
            System.out.println("9-Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios)\n"
                    + "que están ‘limpias’.");
            System.out.println("10-SALIR");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    fs.opcionMenu1();
                    break;
                case 2:
                    daoC.mostrarCasasDisponiblesEntre();
                    break;
                case 3:
                    fs.opcionMenu3();
                    break;
                case 4:
                    cs.opcionMenu4();
                    break;
                case 5:
                    daoCl.mostrarClientesConComentarios();
                    break;
                case 6:
                    daoE.mostrarEstanciasReservadasPorUnCliente();
                    break;
                case 7:
                    daoC.aumentarPrecio();
                    break;
                case 8:
                    daoC.mostrarCantidadDeCasasEnPaises();
                    break;
                case 9:
                    daoC.mostrarCasasLimpiasDeReinoUnido();
                    break;

                default:
                    System.out.println("La opcion elegida es invalida");
            }
        } while (opc != 0);
    }
}
