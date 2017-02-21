package controlador;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import utils.ValidadorCamposEntrada;
import vista.Crear;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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

        this.cargarMarcas();
        this.cargarEficiencias();
        this.iniciarListeners();
    }

    private void cargarEficiencias() {
        List<Eficiencia> eficiencias = gestorPersistencia.getEficienciaPersistencia().getTodasEficiencias();
        Vector vEficiencias = new Vector();

        for (Eficiencia eficiencia : eficiencias) {
            vEficiencias.add(eficiencia.getNombre());
        }

        crear.addModeloEficiencias(vEficiencias);
    }

    private void cargarMarcas() {
        List<Marca> marcas = gestorPersistencia.getMarcaPersistencia().getTodasMarcas();
        Vector vMarcas = new Vector();

        for (Marca marca : marcas) {
            vMarcas.add(marca.getNombre());
        }

        crear.addModeloMarcas(vMarcas);
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
            crear.cerrarDialogo();
        } else {
            crear.mostrarCamposErroneos();
        }
    }
}
