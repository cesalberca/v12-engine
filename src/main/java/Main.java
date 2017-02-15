import controlador.AppControlador;
import persistencia.GestorPersistencia;
import vista.App;

/**
 * Clase principal de V12 Engine. Aquí se declara la vista, el gestor de persistencia el controlador de la app
 */
public class Main {
    public static void main(String[] args) {
        App app = new App();
        GestorPersistencia gestorPersistencia = new GestorPersistencia();
        new AppControlador(app, gestorPersistencia);
    }
}
