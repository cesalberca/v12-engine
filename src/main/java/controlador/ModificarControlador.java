package controlador;

import persistencia.GestorPersistencia;
import vista.Modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador de {@link Modificar}
 */
public class ModificarControlador {
    private Modificar modificar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener modificarElementoListener, marcaSeleccionadaListener, modeloSeleccionadoListener, cerrarListener;

    public ModificarControlador(Modificar modificar, GestorPersistencia gestorPersistencia) {
        this.modificar = modificar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        modificarElementoListener = actionEvent -> {
            modificar.cerrarDialogo();
            modificar.mostrarModificadoCorrectamente();
        };

        modificar.getButtonOK().addActionListener(modificarElementoListener);

        cerrarListener = actionEvent -> {
            modificar.cerrarDialogo();
        };

        modificar.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> {
            modificar.onMarcaSeleccionado();
        };

        modificar.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> {
            modificar.onModeloSeleccionado();
        };

        modificar.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }
}
