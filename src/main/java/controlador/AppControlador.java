package controlador;

import modelo.Exportador;
import modelo.entidades.Eficiencia;
import modelo.entidades.Modelo;
import persistencia.EficienciaPersistencia;
import persistencia.GestorPersistencia;
import persistencia.ModeloPersistencia;
import utils.AdaptadorTabla;
import vista.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

/**
 * Controlador principal de la vista. Aquí se inicializan todos los action listeners.
 */
public class AppControlador {
    private App app;
    private GestorPersistencia gestorPersistencia;
    private ActionListener abrirEficiencias, abrirModificar, abrirEliminar, abrirBuscar, exportar;
    private Vector<String> vResultados;
    private Vector vDatos;
    private DefaultTableModel dtm;

    public AppControlador(App app, GestorPersistencia gestorPersistencia) {
        this.app = app;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
        this.cargarTabla();
    }

    /**
     * Inicializamos los listeners de la vista. Para ello recogemos de la vista los jbuttons.
     * Generamos el controlador desde aquí y le pasamos el gestor de persistencia.
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

    private void cargarTabla(){
        ModeloPersistencia modelo = new ModeloPersistencia();
        EficienciaPersistencia eficienciaPersistencia = new EficienciaPersistencia();
        Eficiencia eficiencia = eficienciaPersistencia.getEficiencia(1);

        //adaptador de renderizar la jtable y poder meter un jlabel
        app.getJtResultados().setDefaultRenderer(Object.class, new AdaptadorTabla()); //aqui se renderiza
        //altura de los registros
        app.getJtResultados().setRowHeight(50);
        vResultados = new Vector<>(Arrays.asList("Nombre marca", "Nombre modelo", "Consumo", "Emisiones", "Clasificación energética", "Fotografía"));
        dtm = new DefaultTableModel(vResultados,0);
        for (Modelo model: modelo.getTodosModelos()) {
            try {
                //aqui pasamos la foto
                byte[] imagen = eficiencia.getImagen().getBytes(1, (int) eficiencia.getImagen().length()-1);
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagen));
                Object[] fila = new Object[1];
                ImageIcon icono = new ImageIcon(img);
                fila[0] = new JLabel(icono);
                vDatos = new Vector<>(Arrays.asList(model.getMarca().getNombre(),model.getNombre(),model.getConsumo(),model.getEmisiones(),model.getEficiencia().getNombre(), fila[0]));
                dtm.addRow(vDatos);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        app.getJtResultados().setModel(dtm);
    }
}
