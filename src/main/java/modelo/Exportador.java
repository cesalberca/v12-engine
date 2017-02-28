package modelo;

import modelo.entidades.Modelo;
import utils.CSVUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que exporta a ficheros datos
 */
public class Exportador {
    /**
     * Exporta a csv un arraylist de objetos dada una ruta
     * @param modelos {@link Modelo}s a exportar
     * @param rutaElegida Ruta del fichero
     */
    public static void csv(List<Modelo> modelos, String rutaElegida) throws IOException {
        FileWriter escritor = new FileWriter(rutaElegida);
        CSVUtils.writeLine(escritor, Arrays.asList("Id", "Nombre", "Consumo", "Emisiones", "Marca", "ID Eficiencia", "Nombre Eficiencia"), ';');

        for (Modelo modelo : modelos) {
            List<String> lista = new ArrayList<>();

            lista.add(String.valueOf(modelo.getId()));
            lista.add(modelo.getNombre());
            lista.add(String.valueOf(modelo.getConsumo()));
            lista.add(String.valueOf(modelo.getEmisiones()));
            lista.add(String.valueOf(modelo.getMarca().getId()));
            lista.add(modelo.getMarca().getNombre());
            lista.add(String.valueOf(modelo.getEficiencia().getId()));
            lista.add(modelo.getEficiencia().getNombre());

            CSVUtils.writeLine(escritor, lista, ';');
        }

        escritor.flush();
        escritor.close();
    }
}
