package persistencia;

import modelo.entidades.Marca;

import java.util.List;

/**
 * Created by allen on 14/02/2017.
 */
public interface MarcaDao {

    List<Marca> getTodasMarcas();
    Marca getMarca(int id);
    void crearMarca(Marca marca);
    void actualizarMarca(Marca marca);
    void eliminarMarca(Marca marca);
}
