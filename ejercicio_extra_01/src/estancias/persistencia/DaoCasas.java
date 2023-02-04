package estancias.persistencia;

import estancias.entidades.Casas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class DaoCasas extends DAO {

    //Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de
//2020 y el 31 de agosto de 2020 en Reino Unido.
    public void mostrarCasasDisponiblesEntre() throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde BETWEEN "
                    + "'2020-08-01' AND '2020-08-31' AND pais = 'Reino Unido';";
            consultarBase(sql);
            Casas casa = null;
            List<Casas> casuchas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setFecha_desde(resultado.getDate("Fecha_desde"));
                casa.setFecha_hasta(resultado.getDate("Fecha_hasta"));
                casa.setPais(resultado.getString(6));
                casuchas.add(casa);
            }
            for (Casas aux : casuchas) {
                System.out.println(aux.getPais() + " " + aux.getFecha_desde() + " " + aux.getFecha_hasta());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }

    public void vacacionesDesde(Date fecha_desde, Date fecha_hasta, int cant) throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE fecha_desde <= "
                    + "'" + new SimpleDateFormat("yyyy-MM-dd").format(fecha_desde)
                    + "' AND fecha_hasta >='" + new SimpleDateFormat("yyyy-MM-dd").format(fecha_hasta) + "'"
                    + " AND tiempo_minimo <= " + cant + " AND tiempo_maximo >= " + cant + ";";
            consultarBase(sql);
            Casas casa = null;
            List<Casas> casuchas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setFecha_desde(resultado.getDate("Fecha_desde"));
                casa.setFecha_hasta(resultado.getDate("Fecha_hasta"));
                casa.setId_casa(resultado.getInt(1));
                casuchas.add(casa);
            }
            for (Casas aux : casuchas) {
                System.out.println(aux.getId_casa() + " " + aux.getFecha_desde() + " " + aux.getFecha_hasta());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }

    public List<Casas> traerCasasDeReinoUnido() throws Exception {
        List<Casas> casasReinoUnido = new ArrayList();
        try {
            String sql = "SELECT id_casa, precio_habitacion FROM casas WHERE pais = 'Reino Unido';";
            consultarBase(sql);

            while (resultado.next()) {
                Casas c = new Casas();
                c.setId_casa(resultado.getInt(1));
                c.setPrecio_habitacion(resultado.getDouble(2));
                casasReinoUnido.add(c);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
            return casasReinoUnido;
        }
    }

    public void aumentarPrecio() throws Exception {
        try {
            List<Casas> casas = traerCasasDeReinoUnido();
            for (Casas aux : casas) {

                aux.setPrecio_habitacion(aux.getPrecio_habitacion() + (aux.getPrecio_habitacion() * 0.05));

                String sql = "UPDATE casas SET precio_habitacion = " + aux.getPrecio_habitacion() + " WHERE id_casa = " + aux.getId_casa() + ";";
                insertarModificarEliminar(sql);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();

        }
    }

    public void mostrarCantidadDeCasasEnPaises() throws Exception {
        try {
            String sql = "SELECT pais, count(pais) FROM casas GROUP BY pais;";
            consultarBase(sql);
            while (resultado.next()) {
                System.out.println(resultado.getString(1) + "-->" + resultado.getInt(2));
            }
        } catch (Exception e) {
            throw e;

        } finally {
            desconectarBase();
        }
    }

    public void mostrarCasasLimpiasDeReinoUnido() throws Exception {
        try {
            String sql = "SELECT c.id_casa, co.comentario FROM casas c "
                    + "INNER JOIN comentarios co ON c.id_casa = co.id_casa "
                    + "WHERE co.comentario LIKE '%limpia%' AND c.pais = 'Reino Unido';";
            consultarBase(sql);
            while (resultado.next()) {
                System.out.println(resultado.getInt(1)+" "+resultado.getString(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
