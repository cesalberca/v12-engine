package modelo;

import modelo.entidades.Marca;
import org.hibernate.Session;
import utils.HibernateUtil;

public class GestorModelos {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public GestorModelos() {
        this.session.beginTransaction();
        Marca marca = new Marca("Test");
        this.session.save(marca);
        System.out.println(marca);
        this.session.getTransaction().commit();
        System.out.println("Guardado");
    }
}
