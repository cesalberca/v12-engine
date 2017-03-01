package controlador;

import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import vista.Eliminar;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class EliminarControlador {
    private Eliminar eliminar;
    private String elementoSeleccionado = "";
    private GestorPersistencia gestorPersistencia;
    private ActionListener eliminarElementoListener, marcaSeleccionadaListener, modeloSeleccionadoListener, cerrarListener;
    private List<Marca> marca;
    private List<Modelo> modelo;

    public EliminarControlador(Eliminar eliminar, GestorPersistencia gestorPersistencia) {
        this.eliminar= eliminar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void cargarModelos(){
        modelo = gestorPersistencia.getModeloPersistencia().getTodosModelos();
        Vector vModelo = new Vector();

        for (Modelo modelos: modelo) {
            vModelo.add(modelos.getNombre());
        }

        eliminar.addModelModelo(vModelo);
    }

    private void cargarMarcas(){
        marca = gestorPersistencia.getMarcaPersistencia().getTodasMarcas();
        Vector vMarcas = new Vector();

        for (Marca marcas: marca) {
            vMarcas.add(marcas.getNombre());
        }

        eliminar.addModeloMarcas(vMarcas);
    }

    private void iniciarListeners() {


        eliminarElementoListener = actionEvent ->{
            this.eliminarEntrada();
            eliminar.cerrarDialogo();
        };
        eliminar.getButtonOK().addActionListener(eliminarElementoListener);

        cerrarListener = actionEvent -> eliminar.cerrarDialogo();
        eliminar.getButtonCancel().addActionListener(cerrarListener);

        marcaSeleccionadaListener = actionEvent -> {
            eliminar.onMarcaSeleccionado();
            cargarMarcas();
            this.elementoSeleccionado = "marca";
        };
        eliminar.getRbtnMarca().addActionListener(marcaSeleccionadaListener);

        modeloSeleccionadoListener = actionEvent -> {
            eliminar.onModeloSeleccionado();
            cargarModelos();
            this.elementoSeleccionado = "modelo";
        };
        eliminar.getRbtnModelo().addActionListener(modeloSeleccionadoListener);
    }

    private void eliminarEntrada(){
        switch(elementoSeleccionado){
            case "marca":
                gestorPersistencia.getMarcaPersistencia().getMarca(eliminar.getCbNombre().getSelectedIndex());
                break;
            case "modelo":
               // gestorPersistencia.getModeloPersistencia().eliminarModelo();
        }
    }
}
