package persistencia;

import modelo.entidades.Eficiencia;

import java.util.List;

public interface EficienciaDao {
    List<Eficiencia> getTodasEficiencias();
    Eficiencia getEficiencia(int id);
}
