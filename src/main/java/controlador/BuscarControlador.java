package controlador;

import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import vista.Buscar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuscarControlador {
    private Buscar buscar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener buscarListener, marcaSeleccionadaListener, consumoSeleccionadoListener, emisionSeleccionadoListener, clasificacionSeleccionadoListener, cerrarListener;
    private ArrayList<Modelo> almodelos;
    public BuscarControlador(Buscar buscar, GestorPersistencia gestorPersistencia, ArrayList<Modelo> modelos) {
        this.buscar = buscar;
        this.gestorPersistencia = gestorPersistencia;
        this.almodelos = modelos;

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


    private void buscar(){

    }

    private void llenarDatos(){
        for (Modelo model: almodelos) {
            for (int i = 0;i < buscar.getCbbMarca().getItemCount(); i++){
                if(model.getMarca().getNombre() != buscar.getCbbMarca().getItemAt(i)){
                   /* buscar.getCbbMarca().addItem();*/
                }
            }
        }
    }
}
