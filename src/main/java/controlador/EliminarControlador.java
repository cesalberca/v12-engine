package controlador;

import persistencia.GestorPersistencia;
import vista.Eliminar;

import java.awt.event.ActionListener;

/**
 * Created by juanxxiii on 14/02/2017.
 */
public class EliminarControlador {
    private Eliminar eliminar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener eliminarElementoListener, marcaSeleccionadaListener, modeloSeleccionadoListener, cerrarListener;

    public EliminarControlador(Eliminar eliminar, GestorPersistencia gestorPersistencia) {
        this.eliminar= eliminar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        eliminarElementoListener = actionEvent -> {
            eliminar.cerrarDialogo();
            eliminar.mostrarEliminadoCorrectamente();
        };

        eliminar.getButtonOK().addActionListener(eliminarElementoListener);

        cerrarListener = actionEvent -> {
            eliminar.cerrarDialogo();
        };

        eliminar.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> {
            eliminar.onMarcaSeleccionado();
        };

        eliminar.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> {
            eliminar.onModeloSeleccionado();
        };

        eliminar.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }
}
