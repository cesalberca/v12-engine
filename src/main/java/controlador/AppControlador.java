package controlador;

import modelo.Exportador;
import persistencia.GestorPersistencia;
import vista.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

/**
 * Controlador principal de la vista. Aquí se inicializan todos los action listeners.
 */
public class AppControlador {
    private App app;
    private GestorPersistencia gestorPersistencia;
    private ActionListener abrirEficiencias, abrirModificar, abrirEliminar, abrirBuscar, exportar;
    private ActionListener abrirEficiencias, abrirModificar, abrirEliminar, abrirBuscar;
    private Vector<String> vResultados;
    private Vector<String> datos;
    private DefaultTableModel dtm;

    public AppControlador(App app, GestorPersistencia gestorPersistencia) {
        this.app = app;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
        this.iniciarTabla();
    }

    /**
     * Inicializamos los listeners de la vista. Para ello recogemos de la vista los jbuttons. Generamos el controlador desde aquí y le pasamos el gestor de persistencia.
     */
    private void iniciarListeners() {
        abrirEficiencias = actionEvent -> {
            Crear crear = new Crear();
            new CrearControlador(crear, gestorPersistencia);
            crear.setTitle("Crear nuevo elemento");
            crear.pack();
            crear.setLocationRelativeTo(null);
            crear.setVisible(true);
        };

        app.getCrearButton().addActionListener(abrirEficiencias);

        abrirModificar = e -> {
            Modificar modificar = new Modificar();
            new ModificarControlador(modificar, gestorPersistencia);
            modificar.setTitle("Modificar elemento");
            modificar.pack();
            modificar.setLocationRelativeTo(null);
            modificar.setVisible(true);
        };

        app.getModificarButton().addActionListener(abrirModificar);

        abrirBuscar = actionEvent -> {
            Buscar buscar = new Buscar();
            new BuscarControlador(buscar, gestorPersistencia);
            buscar.setTitle("Buscar elemento");
            buscar.pack();
            buscar.setLocationRelativeTo(null);
            buscar.setVisible(true);
        };

        app.getBuscarButton().addActionListener(abrirBuscar);

        abrirEliminar = actionEvent -> {
            Eliminar eliminar = new Eliminar();
            new EliminarControlador(eliminar, gestorPersistencia);
            eliminar.setTitle("Eliminar elemento");
            eliminar.pack();
            eliminar.setLocationRelativeTo(null);
            eliminar.setVisible(true);
        };

        app.getEliminarButton().addActionListener(abrirEliminar);

        exportar = actionEvent -> {
            String ruta = app.getRutaParaExportar();

            if (ruta.isEmpty()) {
                app.notificarErrorExportacion();
            } else {
                try {
                    Exportador.csv(gestorPersistencia.getModeloPersistencia().getTodosModelos(), ruta);
                    app.notificarExportacionCompletada();
                } catch (IOException e) {
                    app.notificarErrorExportacion();
                }
            }
        };

        app.getExportarButton().addActionListener(exportar);
    }

    private void iniciarTabla(){
        vResultados = new Vector<>(Arrays.asList("Nombre marca", "Nombre modelo", "Consumo", "Emisiones", "Clasificación energética"));

        dtm = new DefaultTableModel(vResultados,5);
        app.getJtResultados().setModel(dtm);
    }
}
