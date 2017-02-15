package controlador;

import persistencia.GestorPersistencia;
import vista.App;
import vista.Crear;
import vista.Eliminar;
import vista.Modificar;

import java.awt.event.ActionListener;

/**
 * Controlador principal de la vista. Aquí se inicializan todos los action listeners.
 */
public class AppControlador {
    private App app;
    private GestorPersistencia gestorPersistencia;
    private ActionListener abrirEficiencias, abrirModificar, abrirEliminar;

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
            new CrearControlador(crear, gestorPersistencia);
            crear.setTitle("Crear nuevo elemento");
            crear.pack();
            crear.setLocationRelativeTo(null);
            crear.setVisible(true);
        };

        app.getCrearButton().addActionListener(abrirEficiencias);

        abrirModificar = e -> {
            Modificar modificar = new Modificar();
            new ModificarControlador(modificar, gestorPersistencia);
            modificar.setTitle("Modificar elemento");
            modificar.pack();
            modificar.setLocationRelativeTo(null);
            modificar.setVisible(true);
        };

        app.getModificarButton().addActionListener(abrirModificar);

        abrirEliminar = actionEvent -> {
            Eliminar eliminar = new Eliminar();
            new EliminarControlador(eliminar, gestorPersistencia);
            eliminar.setTitle("Eliminar elemento");
            eliminar.pack();
            eliminar.setLocationRelativeTo(null);
            eliminar.setVisible(true);
        };

        app.getEliminarButton().addActionListener(abrirEliminar);
    }
}
