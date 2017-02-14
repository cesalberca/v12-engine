package controlador;

import persistencia.GestorPersistencia;
import vista.Crear;

import java.awt.event.ActionListener;

/**
 * Controlador de {@link Crear}
 */
public class CrearControlador {
    private Crear crear;
    private GestorPersistencia gestorPersistencia;
    private ActionListener crearListener;

    public CrearControlador(Crear crear, GestorPersistencia gestorPersistencia) {
        this.crear = crear;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        crearListener = actionEvent -> {
            crear.mostrarCreadoCorrectamente();
        };

        crear.getButtonOK().addActionListener(crearListener);
    }
}
