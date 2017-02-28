package persistencia;


import modelo.CocheInicio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CocheInicioPersistencia implements CocheInicioDao {
    @Override
    public List<CocheInicio> listarCoches() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        ArrayList<CocheInicio> lista = new ArrayList<>();

/*
        lista = sesion.createQuery("SELECT * FROM modelo")

*/
        return null;
    }

    @Override
    public CocheInicio getCoche(int id) {
        return null;
    }

    @Override
    public void crearCocheIinicio(CocheInicio coche) {

    }
}
