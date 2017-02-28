package persistencia;

import modelo.CocheInicio;

import java.util.List;

public interface CocheInicioDao {
     List<CocheInicio> listarCoches();
     CocheInicio getCoche(int id);
     void crearCocheIinicio(CocheInicio coche);

}
