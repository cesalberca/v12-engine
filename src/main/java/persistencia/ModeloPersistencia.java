package persistencia;


import modelo.entidades.Eficiencia;
import modelo.entidades.Modelo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.List;

public class ModeloPersistencia implements ModeloDao{


    @Override
    public List<Modelo> getTodosModelos() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        TypedQuery<Modelo> query = sesion.createQuery("FROM Modelo", Modelo.class);
        List<Modelo> list = query.getResultList();
        tx.commit();
        sesion.close();
        return list;
        
    }

    @Override
    public Modelo getModelo(int id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Modelo modelo = sesion.get(Modelo.class, id);
        tx.commit();
        sesion.close();
        return modelo;

    }

    @Override
    public void createModelo(Modelo modelo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(modelo);
        tx.commit();
        sesion.close();
    }

    @Override
    public void actualizarModelo(Modelo modelo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.saveOrUpdate(modelo);
        tx.commit();
        sesion.close();
    }

    @Override
    public void eliminarModelo(Modelo modelo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(modelo);
        tx.commit();
        sesion.close();
    }
}