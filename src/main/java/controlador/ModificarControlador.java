package controlador;

import persistencia.GestorPersistencia;
import vista.Modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador de {@link Modificar}
 */
public class ModificarControlador {
    private Modificar modificar;
    private GestorPersistencia gestorPersistencia;
    private ActionListener modificarElementoListener;

    public ModificarControlador(Modificar modificar, GestorPersistencia gestorPersistencia) {
        this.modificar = modificar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListeners();
    }

    private void iniciarListeners() {
        modificarElementoListener = e -> {
//                gestorPersistencia.save(elemento);
        };

        modificar.getModificarButton().addActionListener(modificarElementoListener);
    }
}
