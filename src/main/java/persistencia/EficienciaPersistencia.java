package persistencia;

import modelo.entidades.Eficiencia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class EficienciaPersistencia implements EficienciaDao {
    @Override
    public List<Eficiencia> getTodasEficiencias() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        List<Eficiencia> listEficiencias = session.createQuery("FROM Eficiencia").list();

        tx.commit();
        session.close();

        return listEficiencias;
    }

    @Override
    public Eficiencia getEficiencia(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Eficiencia eficiencia = session.get(Eficiencia.class, id);
        tx.commit();
        session.close();

        return eficiencia;
    }

    @Override
    public void crearEficiencia(Eficiencia eficiencia) {

    }

    @Override
    public void actualizarEficiencia(Eficiencia eficiencia) {

    }

    @Override
    public void eliminarEficiencia(Eficiencia eficiencia) {

    }
}
