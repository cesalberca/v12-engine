package controlador;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
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


    public ModificarControlador(Modificar modificar, GestorPersistencia gestorPersistencia) {
        this.modificar = modificar;
        this.gestorPersistencia = gestorPersistencia;
        this.cargarEficiencias();
        this.iniciarListeners();
        this.cargarMarcas();
    }

    private void cargarEficiencias() {
        eficiencias = gestorPersistencia.getEficienciaPersistencia().getTodasEficiencias();
        Vector vEficiencias = new Vector();

        for (Eficiencia eficiencia : eficiencias) {
            vEficiencias.add(eficiencia.getNombre());
        }

        modificar.addModeloEficiencias(vEficiencias);
    }

    private void cargarMarcas() {
        marcas = gestorPersistencia.getMarcaPersistencia().getTodasMarcas();
        Vector vMarcas = new Vector();

        for (Marca marca : marcas) {
            vMarcas.add(marca.getNombre());
        }

        modificar.addModeloMarcas(vMarcas);
    }


    private void iniciarListeners() {
        modificarElementoListener = actionEvent -> modificar.cerrarDialogo();
        modificar.getButtonOK().addActionListener(modificarElementoListener);

        cerrarListener = actionEvent -> modificar.cerrarDialogo();
        modificar.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> modificar.onMarcaSeleccionado();
        modificar.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> modificar.onModeloSeleccionado();
        modificar.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }
}
