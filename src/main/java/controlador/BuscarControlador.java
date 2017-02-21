package controlador;

import persistencia.GestorPersistencia;
import vista.Buscar;

import java.awt.*;
import java.awt.event.ActionListener;

public class BuscarControlador {
    private Buscar buscar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener buscarListener, marcaSeleccionadaListener, consumoSeleccionadoListener, emisionSeleccionadoListener, clasificacionSeleccionadoListener, cerrarListener;

    public BuscarControlador(Buscar buscar, GestorPersistencia gestorPersistencia) {
        this.buscar = buscar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListener();
    }

    private void iniciarListener() {
        buscarListener = actionEvent -> buscar.cerrarDialogo();
        buscar.getButtonOK().addActionListener(buscarListener);

        marcaSeleccionadaListener = actionEvent -> buscar.onMarcaSeleccionado();
        buscar.getCbMarca().addActionListener(marcaSeleccionadaListener);


        consumoSeleccionadoListener = actionEvent -> buscar.onConsumoSeleccionado();
        buscar.getCbConsumo().addActionListener(consumoSeleccionadoListener);


        emisionSeleccionadoListener = actionEvent -> buscar.onEmisionesSeleccionado();
        buscar.getCbEmisiones().addActionListener(emisionSeleccionadoListener);


        clasificacionSeleccionadoListener = actionEvent -> buscar.onClasificacionSeleccionado();
        buscar.getCbClasificacion().addActionListener(clasificacionSeleccionadoListener);


        cerrarListener = actionEvent -> buscar.cerrarDialogo();
        buscar.getButtonCancel().addActionListener(cerrarListener);
    }
}
