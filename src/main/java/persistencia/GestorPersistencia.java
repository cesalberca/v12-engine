package persistencia;

/**
 * Clase que gestiona toda la persitencia de la aplicación.
 * Tiene referencias actualizadas de los modelos, las eficiencias y las marcas.
 * Es una clase que es sujeto y observadora.
 * Esta clase observa las demás persistencias y éstas notifican los cambios a esta clase.
 * Además esta clase a su vez es sujeto, ya que el controlador mirará cambios sobre esta clase.
 */
public class GestorPersistencia {
    private EficienciaPersistencia eficienciaPersistencia;
    private MarcaPersistencia marcaPersistencia;
    private ModeloPersistencia modeloPersistencia;

    public GestorPersistencia() {
        this.eficienciaPersistencia = new EficienciaPersistencia();
        this.marcaPersistencia = new MarcaPersistencia();
        this.modeloPersistencia = new ModeloPersistencia();
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
