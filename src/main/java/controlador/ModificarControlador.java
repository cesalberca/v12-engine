package controlador;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;

import vista.Modificar;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * Controlador de {@link Modificar}
 */
public class ModificarControlador {
    private Modificar modificar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener modificarElementoListener, marcaSeleccionadaListener, modeloSeleccionadoListener, cerrarListener;
    private List<Eficiencia> eficiencias;
    private List<Marca> marcas;
    private List<Modelo> modelos;
    private String elementoSeleccionado = "";

    public ModificarControlador(Modificar modificar, GestorPersistencia gestorPersistencia) {
        this.modificar = modificar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void cargarElementosSeleccionados() {
        Vector elementos = new Vector();

        switch (elementoSeleccionado) {
            case "marca":
                marcas = gestorPersistencia.getMarcaPersistencia().getMarcas();

                for (Marca marca : marcas) {
                    elementos.add(marca.getNombre());
                }
                break;
            case "modelo":
                modelos = gestorPersistencia.getModeloPersistencia().getModelos();

                for (Modelo modelo : modelos) {
                    elementos.add(modelo.getNombre());
                }
                break;
        }

        modificar.addModeloElementoAModificar(elementos);
    }

    private void cargarEficiencias() {
        eficiencias = gestorPersistencia.getEficienciaPersistencia().getEficiencias();
        Vector vEficiencias = new Vector();

        for (Eficiencia eficiencia : eficiencias) {
            vEficiencias.add(eficiencia.getNombre());
        }

        modificar.addModeloEficiencias(vEficiencias);
    }

    private void cargarMarcas() {
        marcas = gestorPersistencia.getMarcaPersistencia().getMarcas();
        Vector vMarcas = new Vector();

        for (Marca marca : marcas) {
            vMarcas.add(marca.getNombre());
        }

        modificar.addModeloMarcas(vMarcas);
    }

    private void actualizarEntrada() {
        switch (elementoSeleccionado) {
            case "marca":
                Marca marcaSeleccionada = marcas.get(modificar.getcbNombre().getSelectedIndex());
                marcaSeleccionada.setNombre(modificar.getTfNombre().getText());
                gestorPersistencia.getMarcaPersistencia().actualizarMarca(marcaSeleccionada);
                break;
            case "modelo":
                Modelo modeloSeleccionado = modelos.get(modificar.getcbNombre().getSelectedIndex());
                modeloSeleccionado.setNombre(modificar.getTfNombre().getText());
                modeloSeleccionado.setConsumo(Double.parseDouble(modificar.getTfConsumo().getText()));
                modeloSeleccionado.setEmisiones(Double.parseDouble(modificar.getTfEmisiones().getText()));
                gestorPersistencia.getModeloPersistencia().actualizarModelo(modeloSeleccionado);
                break;
        }
    }

    private void iniciarListeners() {
        modificarElementoListener = actionEvent -> {
            actualizarEntrada();
            modificar.cerrarDialogo();
        };
        modificar.getButtonOK().addActionListener(modificarElementoListener);

        cerrarListener = actionEvent -> modificar.cerrarDialogo();
        modificar.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> {
            elementoSeleccionado = "marca";
            modificar.onMarcaSeleccionado();
            cargarMarcas();
            cargarElementosSeleccionados();
        };
        modificar.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> {
            elementoSeleccionado = "modelo";
            modificar.onModeloSeleccionado();
            cargarEficiencias();
            cargarMarcas();
            cargarElementosSeleccionados();
        };
        modificar.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }
}
