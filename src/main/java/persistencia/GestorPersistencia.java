package persistencia;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;

import java.util.List;

public class GestorPersistencia {

    public GestorPersistencia(){
//        EficienciaPersistencia eficienciaPersistencia = new EficienciaPersistencia();
//
//        Eficiencia eficienciaActualiazada = eficienciaPersistencia.getEficiencia(2);
//        eficienciaActualiazada.setNombre("Test");
//        eficienciaPersistencia.actualizarEficiencia(eficienciaActualiazada);
        
        Eficiencia eficiencia = new Eficiencia("nuevo","Any String you want".getBytes());
        Marca marca = new Marca("Peugeot");
        ModeloPersistencia modeloPersistencia = new ModeloPersistencia();
        Modelo m = new Modelo("308",10,20,marca,eficiencia);
        modeloPersistencia.createModelo(m);
//        Modelo modelo = modeloPersistencia.getModelo(1);
//        modelo.setNombre("Ford");
//        modeloPersistencia.actualizarModelo(modelo);






//        for (Eficiencia eficiencia : eficienciaPersistencia.getTodasEficiencias()) {
//            System.out.println(eficiencia);
//        }

//        System.out.println(eficienciaPersistencia.getEficiencia(2).toString());
//        byte[] myvar = "Any String you want".getBytes();
//
//        eficienciaPersistencia.crearEficiencia(new Eficiencia("Nueva eficiencia", myvar));
    }
}
