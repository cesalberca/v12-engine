package utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Utilidades generales para escribir CSV
 */
public class CSVUtils {
    private static final char DEFAULT_SEPARATOR = ',';

    /**
     * Escribe una línea
     * @param w Escritor
     * @param values Valores
     * @throws IOException Error al escribir
     */
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    /**
     * Escribe una línea
     * @param w Escritor
     * @param values Valores
     * @param separators Separador
     * @throws IOException Error al escribir
     */
    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    /**
     * Escribe una línea
     * @param w Escritor
     * @param values Valores
     * @param separators Separador personalizado
     * @param customQuote Símbolo de separación
     * @throws IOException Error al escribir
     */
    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {
        boolean first = true;

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
}
