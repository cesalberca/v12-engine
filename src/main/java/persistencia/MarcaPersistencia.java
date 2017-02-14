package persistencia;

import modelo.entidades.Marca;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by allen on 14/02/2017.
 */
public class MarcaPersistencia implements MarcaDao {

    @Override
    public List<Marca> getTodasMarcas() {
        ArrayList<Marca> alMarcas = new ArrayList<Marca>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List listMarcas = session.createQuery("FROM Marca").list();

        tx.commit();
        session.close();

        return listMarcas;
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
