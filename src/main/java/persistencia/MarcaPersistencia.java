package persistencia;

import modelo.entidades.Marca;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarcaPersistencia implements MarcaDao {
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

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Marca marca  = (Marca) session.createQuery("FROM Marca where id =" +id);


        tx.commit();
        session.close();

        return marca;
    }

    @Override
    public void crearMarca(Marca marca) {

    }

    @Override
    public void actualizarMarca(Marca marca) {

    }

    @Override
    public void eliminarMarca(Marca marca) {

    }
}
