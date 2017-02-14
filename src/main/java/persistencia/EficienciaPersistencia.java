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
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Eficiencia eficiencia = sesion.get(Eficiencia.class, id);
        tx.commit();
        sesion.close();

        return eficiencia;
    }

    @Override
    public void crearEficiencia(Eficiencia eficiencia) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(eficiencia);
        tx.commit();
        sesion.close();
    }

    @Override
    public void actualizarEficiencia(Eficiencia eficiencia) {

    }

    @Override
    public void eliminarEficiencia(Eficiencia eficiencia) {

    }
}
