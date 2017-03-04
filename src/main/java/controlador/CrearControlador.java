package controlador;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import utils.Validador;
import vista.Crear;

import javax.swing.*;
import java.awt.event.ActionListener;
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
    private List<Eficiencia> eficiencias;
    private List<Marca> marcas;

    public CrearControlador(Crear crear, GestorPersistencia gestorPersistencia) {
        this.crear = crear;
        this.gestorPersistencia = gestorPersistencia;

        this.cargarMarcas();
        this.cargarEficiencias();
        this.iniciarListeners();
    }

    private void cargarEficiencias() {
        eficiencias = gestorPersistencia.getEficienciaPersistencia().getTodasEficiencias();
        Vector vEficiencias = new Vector();

        for (Eficiencia eficiencia : eficiencias) {
            vEficiencias.add(eficiencia.getNombre());
        }

        crear.addModeloEficiencias(vEficiencias);
    }

    private void cargarMarcas() {
        marcas = gestorPersistencia.getMarcaPersistencia().getTodasMarcas();
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
                crear.mostrarError();
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

    private void crearEntrada() {
        // Comprobar si es una marca o si es un modelo
        if (itemSeleccionado.equals("marca")) {
            crearMarca();
        } else if (itemSeleccionado.equals("modelo")) {
            crearModelo();
        }
    }

    private void crearMarca() {
        if (Validador.validarCampo(crear.getTfNombre().getText())) {
            gestorPersistencia.getMarcaPersistencia().crearMarca(new Marca(crear.getTfNombre().getText()));
            crear.mostrarCreadoCorrectamente();
            crear.cerrarDialogo();
        } else {
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
        }
    }

    private void crearModelo() {
        Marca marcaSeleccionada = marcas.get(crear.getCbMarcas().getSelectedIndex());
        Eficiencia eficienciaSeleccionada = eficiencias.get(crear.getCbEficiencias().getSelectedIndex());

        // Validación
        if (!Validador.validarCampo(crear.getTfNombre().getText())) {
            JOptionPane.showMessageDialog(null, "Introduce un nombre válido");
            return;
        } else if (!Validador.validarCampoNumerico(crear.getTfConsumo().getText())) {
            JOptionPane.showMessageDialog(null, "Introduce un consumo válido");
            return;
        } else if (!Validador.validarCampoNumerico(crear.getTfEmisiones().getText())) {
            JOptionPane.showMessageDialog(null, "Introduce unas emisiones válidas");
            return;
        }

        Modelo modelo = new Modelo(
            crear.getTfNombre().getText(),
            Double.parseDouble(crear.getTfConsumo().getText()),
            Double.parseDouble(crear.getTfEmisiones().getText())
        );

        modelo.setMarca(marcaSeleccionada);
        modelo.setEficiencia(eficienciaSeleccionada);
        gestorPersistencia.getModeloPersistencia().crearModelo(modelo);
        crear.mostrarCreadoCorrectamente();
        crear.cerrarDialogo();
    }
}
