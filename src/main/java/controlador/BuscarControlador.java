package controlador;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import vista.Buscar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BuscarControlador {
    private Buscar buscar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener buscarListener, marcaSeleccionadaListener, consumoSeleccionadoListener, emisionSeleccionadoListener, clasificacionSeleccionadoListener, cerrarListener;
    private ChangeListener cambioSliderListener;
    private List<Modelo> almodelos;
    private boolean nueva;
    public BuscarControlador(Buscar buscar, GestorPersistencia gestorPersistencia) {
        this.buscar = buscar;
        this.gestorPersistencia = gestorPersistencia;
        this.almodelos = gestorPersistencia.getModeloPersistencia().getModelos();

        this.iniciarListener();
        this.llenarDatos();
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

        cambioSliderListener = e -> buscar.onCambioSlider();
        buscar.getsConsumo().addChangeListener(cambioSliderListener);
    }


    private void buscar(){

    }

    private void llenarDatos(){
        gestorPersistencia.getMarcaPersistencia().getMarcas()
            .forEach(i ->buscar.getCbbMarca().addItem(i.getNombre()));

        gestorPersistencia.getEficienciaPersistencia().getEficiencias()
            .forEach(i -> buscar.getCbbClasificacion().addItem(i.getNombre()));

        gestorPersistencia.getModeloPersistencia().getModelos()
            .forEach(i -> {
                nueva = true;
                for (int j = 1; j < buscar.getCbbEmisiones().getItemCount(); j++) {
                    if(Double.parseDouble(buscar.getCbbEmisiones().getItemAt(j).toString()) == i.getEmisiones()){
                        nueva = false;
                    }
                }
                if(nueva){
                    buscar.getCbbEmisiones().addItem(String.valueOf(i.getEmisiones()));
                }
                if(i.getConsumo() > buscar.getsConsumo().getMaximum()){
                    buscar.getsConsumo().setMaximum((int)i.getConsumo());
                }else if(i.getConsumo()< buscar.getsConsumo().getMinimum()){
                    buscar.getsConsumo().setMinimum((int) i.getConsumo());
                }
            });


    }
}
