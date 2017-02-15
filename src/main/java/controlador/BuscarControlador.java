package controlador;

import persistencia.GestorPersistencia;
import vista.Buscar;

public class BuscarControlador {
    private Buscar buscar;
    private GestorPersistencia gestorPersistencia;

    public BuscarControlador(Buscar buscar, GestorPersistencia gestorPersistencia) {
        this.buscar = buscar;
        this.gestorPersistencia = gestorPersistencia;

        this.iniciarListener();
    }

    private void iniciarListener() {

    }
}
