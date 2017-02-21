package controlador;

import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import utils.ValidadorCamposEntrada;
import vista.Crear;

import java.awt.event.ActionListener;

/**
 * Controlador de {@link Crear}
 */
public class CrearControlador {
    private Crear crear;
    private String itemSeleccionado = "";
    private GestorPersistencia gestorPersistencia;
    private ActionListener crearListener, marcaSeleccionadaListener, modeloSeleccionadoListener, cerrarListener;

    public CrearControlador(Crear crear, GestorPersistencia gestorPersistencia) {
        this.crear = crear;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        crearListener = actionEvent -> {
            try {
                this.crearEntrada();
            } catch (Exception e) {
                crear.mostrarCamposErroneos();
            }
        };

        crear.getButtonOK().addActionListener(crearListener);

        cerrarListener = actionEvent -> {
            crear.cerrarDialogo();
        };

        crear.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> {
          crear.onMarcaSeleccionado();
            this.itemSeleccionado = "marca";
        };

        crear.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> {
            crear.onModeloSeleccionado();
            this.itemSeleccionado = "modelo";
        };

        crear.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }

    private void crearEntrada() throws Exception {
        if (ValidadorCamposEntrada.validarCampo(crear.getTfNombre().getText())) {
            crear.cerrarDialogo();

            // Comprobar si es una marca o si es un modelo
            switch (itemSeleccionado) {
                case "marca":
                    gestorPersistencia.getMarcaPersistencia().crearMarca(new Marca(crear.getTfNombre().getText()));
                    break;
                case "modelo":
                    Modelo modelo = new Modelo(
                        crear.getTfNombre().getText(),
                        Integer.parseInt(crear.getTfConsumo().getText()),
                        Integer.parseInt(crear.getTfEmisiones().getText())
                    );
                    gestorPersistencia.getModeloPersistencia().crearModelo(modelo);
                    break;
            }

            crear.mostrarCreadoCorrectamente();
        } else {
            crear.mostrarCamposErroneos();
        }
    }
}
