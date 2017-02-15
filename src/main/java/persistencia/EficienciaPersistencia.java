package persistencia;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

public class EficienciaPersistencia implements EficienciaDao {
    @Override
    public List<Eficiencia> getTodasEficiencias() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();

        TypedQuery<Eficiencia> query = sesion.createQuery("FROM Eficiencia", Eficiencia.class);
        List<Eficiencia> list = query.getResultList();

        tx.commit();
        sesion.close();

        return list;
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
