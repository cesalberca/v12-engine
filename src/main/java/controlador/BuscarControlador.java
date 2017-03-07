package controlador;

import modelo.entidades.Modelo;
import persistencia.GestorPersistencia;
import vista.Buscar;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarControlador {
    private Buscar buscar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener buscarListener, marcaSeleccionadaListener, consumoSeleccionadoListener, emisionSeleccionadoListener, clasificacionSeleccionadoListener, cerrarListener;
    private ChangeListener cambioSliderListener;
    private List<Modelo> almodelos;
    private boolean nueva;
    private boolean coincideBusqueda;
    private boolean coincideMarca;
    private boolean coincideConsumo;
    private boolean coincideEmisiones;
    private boolean coincideClasificacion;

    public BuscarControlador(Buscar buscar, GestorPersistencia gestorPersistencia) {
        this.buscar = buscar;
        this.gestorPersistencia = gestorPersistencia;
        this.almodelos = gestorPersistencia.getModeloPersistencia().getModelos();

        this.iniciarListener();
        this.llenarDatos();
    }

    private void iniciarListener() {
        buscarListener = actionEvent -> buscar();
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
        buscar.getTaResultados().setText("Modelos encontrados: ");
        gestorPersistencia.getModeloPersistencia().getModelos()
            .forEach(i -> {
                coincideBusqueda = false;
                coincideMarca = true;
                coincideEmisiones = true;
                coincideClasificacion = true;
                coincideConsumo = true;
                if(buscar.getCbMarca().isSelected()){
                    coincideMarca = coincideMarca(i.getMarca().getNombre(), buscar.getCbbMarca().getSelectedItem().toString());
                }
                if(buscar.getCbConsumo().isSelected()){
                    coincideConsumo = coincideConsumo(i.getConsumo(), (double)buscar.getsConsumo().getValue());
                }
                if(buscar.getCbEmisiones().isSelected()){
                    coincideEmisiones = coincideEmisiones(i.getEmisiones(), Double.parseDouble(buscar.getCbbEmisiones().getSelectedItem().toString()));
                }
                if(buscar.getCbClasificacion().isSelected()){
                    coincideClasificacion = coincideClasificacion(i.getEficiencia().getNombre(),buscar.getCbbClasificacion().getSelectedItem().toString());
                }

                if(coincideMarca && coincideConsumo && coincideClasificacion && coincideEmisiones){
                    buscar.getTaResultados().append("\nMarca: " + i.getMarca().getNombre());
                    buscar.getTaResultados().append("\nModelo: " + i.getNombre());
                    buscar.getTaResultados().append("\nConsumo: " + i.getConsumo() + " litros/100km");
                    buscar.getTaResultados().append("\nEmisiones: " + i.getEmisiones() + " gCO2");
                    buscar.getTaResultados().append("\nEficiencia energética: " + i.getEficiencia().getNombre() + "\n");
                    buscar.getTaResultados().append("----------------");
                }
            });
    }

    private boolean coincideMarca(String marcaBuscar, String marcaSeleccionada){
        return marcaBuscar.equals(marcaSeleccionada);
    }

    private boolean coincideConsumo(Double consumoBuscar, Double consumoSeleccionado){
        return consumoBuscar <= consumoSeleccionado;

    }

    private boolean coincideEmisiones(Double emisionesBuscar, Double emisionesSeleccionado){
        return emisionesBuscar <= emisionesSeleccionado;

    }

    private boolean coincideClasificacion(String clasificaiconBuscar, String clasificacionSeleccionado){
        return clasificaiconBuscar.equals(clasificacionSeleccionado);
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
