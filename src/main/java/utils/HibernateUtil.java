package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                .configure()
                .buildSessionFactory();
        } catch (Throwable ex) {
            // TODO lanzar al usuario un diálogo que diga que no hay base de datos
            System.err.println("Error al iniciar el SessionFactory de hibernate." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
