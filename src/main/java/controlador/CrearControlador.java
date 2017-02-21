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
    private ActionListener crearListener, marcaSeleccionadaListener, modeloSeleccionadoListener, cerrarListener;

    public CrearControlador(Crear crear, GestorPersistencia gestorPersistencia) {
        this.crear = crear;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        crearListener = actionEvent -> crear.cerrarDialogo();
        crear.getButtonOK().addActionListener(crearListener);

        cerrarListener = actionEvent -> crear.cerrarDialogo();
        crear.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> crear.onMarcaSeleccionado();
        crear.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> crear.onModeloSeleccionado();
        crear.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }
}
