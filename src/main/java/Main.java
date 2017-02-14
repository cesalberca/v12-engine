import controlador.AppControlador;
import org.hibernate.Session;
import utils.HibernateUtil;
import vista.App;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        AppControlador appControlador = new AppControlador(sesion, app);
    }
}
