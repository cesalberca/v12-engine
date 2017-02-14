package controlador;

import persistencia.GestorPersistencia;
import vista.App;
import vista.Crear;
import vista.Modificar;

import java.awt.event.ActionListener;

/**
 * Controlador principal de la vista. Aquí se inicializan todos los action listeners.
 */
public class AppControlador {
    private App app;
    private GestorPersistencia gestorPersistencia;
    private ActionListener abrirEficiencias, abrirModificar;

    public AppControlador(App app, GestorPersistencia gestorPersistencia) {
        this.app = app;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    /**
     * Inicializamos los listeners de la vista. Para ello recogemos de la vista los jbuttons. Generamos el controlador desde aquí y le pasamos el gestor de persistencia.
     */
    private void iniciarListeners() {
        abrirEficiencias = actionEvent -> {
            Crear crear = new Crear();
            CrearControlador crearControlador = new CrearControlador(crear, gestorPersistencia);
            crear.setLocationRelativeTo(null);
            crear.setTitle("Crear nuevo elemento");
            crear.pack();
            crear.setVisible(true);
        };

        app.getCrearButton().addActionListener(abrirEficiencias);

        abrirModificar = e -> {
            Modificar modificar = new Modificar();
            ModificarControlador modificarControlador = new ModificarControlador(modificar, gestorPersistencia);
            modificar.setLocationRelativeTo(null);
            modificar.setTitle("Modificar elemento");
            modificar.pack();
            modificar.setVisible(true);
        };

        app.getModificarButton().addActionListener(abrirModificar);
    }
}
