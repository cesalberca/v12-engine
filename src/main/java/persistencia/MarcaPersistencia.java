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
    public ArrayList<Marca> getTodasMarcas() {
        ArrayList<Marca> alMarcas = new ArrayList<Marca>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List listMarcas = session.createQuery("FROM Marca").list();

        for (Iterator iterator = listMarcas.iterator(); iterator.hasNext();) {

            Marca marca = (Marca) iterator.next();

            marca = new Marca(marca.getId(),marca.getNombre());

            alMarcas.add(marca);

        }
        tx.commit();
        session.close();

        return alMarcas;
    }

    @Override
    public Marca getmarca(int id) {
        return null;
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
