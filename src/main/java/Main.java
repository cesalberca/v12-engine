import utils.HibernateUtil;
import vista.App;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        App app = new App();
        System.out.println("Cargado todo");
    }
}
