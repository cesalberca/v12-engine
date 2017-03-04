package persistencia;

import modelo.entidades.Marca;
import observador.Sujeto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

public class MarcaPersistencia implements MarcaDao, Sujeto {
    @Override
    public List<Marca> getTodasMarcas() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        TypedQuery<Marca> query = sesion.createQuery("FROM Marca", Marca.class);
        List<Marca> list = query.getResultList();
        tx.commit();
        sesion.close();
        return list;
    }

    @Override
    public Marca getMarca(int id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Marca marca = sesion.get(Marca.class, id);
        tx.commit();
        sesion.close();
        return marca;
    }

    @Override
    public void crearMarca(Marca marca) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(marca);
        tx.commit();
        sesion.close();
        notificarObservadores();
    }

    @Override
    public void actualizarMarca(Marca marca) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.saveOrUpdate(marca);
        tx.commit();
        sesion.close();
        notificarObservadores();
    }

    @Override
    public void eliminarMarca(Marca marca) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(marca);
        tx.commit();
        sesion.close();
        notificarObservadores();
    }

    /*
    @Override
    public int idMarca(String nombre){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        int id = 0
        return id;

    }*/
}
