package persistencia;

import modelo.entidades.Modelo;

import java.util.List;


public interface ModeloDao{
    List<Modelo> getTodosModelos();
    Modelo getModelo(int id);
    void crearModelo(Modelo modelo);
    void actualizarModelo(Modelo modelo);
    void eliminarModelo(Modelo modelo);
}
