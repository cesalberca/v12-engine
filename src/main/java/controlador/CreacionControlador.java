package controlador;

import persistencia.GestorPersistencia;
import vista.Crear;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionControlador {
    private Crear crear;
    private GestorPersistencia gestorPersistencia;
    private ActionListener crearListener;

    public CreacionControlador(Crear crear, GestorPersistencia gestorPersistencia) {
        this.crear = crear;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        crearListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
//                GestorPersistencia.insertar(vista.getModelo());
                System.out.println("Pulsado desde el controlador");
            }
        };

        crear.getButtonOK().addActionListener(crearListener);
    }
}
