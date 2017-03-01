package persistencia;

import utils.HibernateUtil;

public class GestorPersistencia {
    private EficienciaPersistencia eficienciaPersistencia;
    private MarcaPersistencia marcaPersistencia;
    private ModeloPersistencia modeloPersistencia;

    public GestorPersistencia() {
        this.eficienciaPersistencia = new EficienciaPersistencia();
        this.marcaPersistencia = new MarcaPersistencia();
        this.modeloPersistencia = new ModeloPersistencia();

        // Forzamos a que se abrá la sessión
        HibernateUtil.getSessionFactory().openSession();
    }

    public EficienciaPersistencia getEficienciaPersistencia() {
        return eficienciaPersistencia;
    }

    public MarcaPersistencia getMarcaPersistencia() {
        return marcaPersistencia;
    }

    public ModeloPersistencia getModeloPersistencia() {
        return modeloPersistencia;
    }
}
