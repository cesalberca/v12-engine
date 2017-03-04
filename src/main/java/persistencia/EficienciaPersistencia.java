package persistencia;

import modelo.entidades.Eficiencia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Observable;

public class EficienciaPersistencia extends Observable implements EficienciaDao {
    private List<Eficiencia> eficiencias;

    public EficienciaPersistencia() {
        this.setEficiencias(getTodasEficiencias());
    }

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

    public List<Eficiencia> getEficiencias() {
        return eficiencias;
    }

    public void setEficiencias(List<Eficiencia> eficiencias) {
        this.eficiencias = eficiencias;
        setChanged();
        notifyObservers();
    }
}
