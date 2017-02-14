package controlador;

import org.hibernate.Session;
import vista.App;

public class AppControlador {
    private Session sesion;
    private App app;

    public AppControlador(Session sesion, App app) {
        this.sesion = sesion;
        this.app = app;
    }
}
