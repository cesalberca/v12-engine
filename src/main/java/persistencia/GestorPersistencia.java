package persistencia;

import modelo.entidades.Eficiencia;

public class GestorPersistencia {

    public GestorPersistencia(){
        EficienciaPersistencia eficienciaPersistencia = new EficienciaPersistencia();
        for (Eficiencia eficiencia : eficienciaPersistencia.getTodasEficiencias()) {
            System.out.println(eficiencia);
        }
    }
}
