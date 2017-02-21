package controlador;

import persistencia.GestorPersistencia;
import vista.Buscar;

import java.awt.*;
import java.awt.event.ActionListener;

public class BuscarControlador {
    private Buscar buscar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener buscarListener, marcaSeleccionadaListener, marcaDeseleccionadoListener,
    consumoSeleccionadoListener, consumoDeseleccionadoListener, emisionSeleccionadoListener, emisionDeseleccionadoListener,
    clasificacionSeleccionadoListener, clasificacionDeseleccioandoListener, cerrarListener;

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

        marcaDeseleccionadoListener = actionEvent -> buscar.onMarcaDeseleccionado();
        buscar.getCbMarca().addActionListener(marcaDeseleccionadoListener);

        consumoSeleccionadoListener = actionEvent -> buscar.onConsumoSeleccionado();
        buscar.getCbConsumo().addActionListener(consumoSeleccionadoListener);

        consumoDeseleccionadoListener = actionEvent -> buscar.onConsumoDeseleccionado();
        buscar.getCbConsumo().addActionListener(consumoDeseleccionadoListener);

        emisionSeleccionadoListener = actionEvent -> buscar.onEmisionesSeleccionado();
        buscar.getCbEmisiones().addActionListener(emisionSeleccionadoListener);

        emisionDeseleccionadoListener = actionEvent -> buscar.onEmisionesDeseleccionado();
        buscar.getCbEmisiones().addActionListener(emisionDeseleccionadoListener);

        clasificacionSeleccionadoListener = actionEvent -> buscar.onClasificacionSeleccionado();
        buscar.getCbClasificacion().addActionListener(clasificacionSeleccionadoListener);

        clasificacionDeseleccioandoListener = actionEvent -> buscar.onClasificacionDeseleccionado();
        buscar.getCbClasificacion().addActionListener(clasificacionDeseleccioandoListener);

        cerrarListener = actionEvent -> buscar.cerrarDialogo();
        buscar.getButtonCancel().addActionListener(cerrarListener);
    }
}
