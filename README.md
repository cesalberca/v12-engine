# V12 Engine

Gestor de vehículos, con operaciones de buscar, crear, modificar y eliminar. Valida campos, hace gestión de los errores y permite exportar a excel los datos. Hecho en Java y con swing. Implementa el patrón de diseño [MVC](https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador), [Observador](https://es.wikipedia.org/wiki/Observer_(patr%C3%B3n_de_dise%C3%B1o)) y [DAO](https://es.wikipedia.org/wiki/Data_Access_Object). Cuenta con base de datos MySQL en remoto y hace uso de Hibernate.

Por [Sergio de la Paz](https://github.com/bote212), [Víctor Allende](https://github.com/victAll), [César Alberca](https://github.com/cesalberca) y [Adrián de la Gala](https://github.com/galaterro)

# Observador

Esta aplicación implementa el patrón observador. Todas las persistencias son Observables, lo que quiere decir que si los datos de una persistencia cambian, las clases que observen a esa persistencia son notificadas y actualizadas automáticamente.

Cada persistencia tiene una List de objetos de esa persistencia. Esta lista __siempre__ está actualizada ya que se recarga automáticamente cada vez que se hacen operaciones que generan nuevos datos en la base de datos, por ejemplo, al crear, modificar y eliminar.

Es por ello por lo que es __sumamente importante__ que no se acceda al método `getTodasEficiencias()` sino al `getEficiencias()`. La diferencia es que `getTodasEficiencias()` hará llamada a la base de datos mientras que `getEficiencias()` no.

# MVC

## Vista

La Vista no debe tener lógica. Si es necesario conseguir datos de la vista, se hará un getter de ese elemento y se tratará desde el controlador. Por ejemplo, imaginemos que tenemos un `JButton` y queremos hacer un evento cuando pulsemos este botón. Para ello hay que hacer un getter en la vista y retornar el botón entero. Al hacerlo de esta forma nos aseguramos que la vista no tiene conocimiento alguno del controlador, ya que si pusiésemos en la vista la acción que debe hacer el botón ya estaríamos mezclando capas.

## Controlador

Recibe una vista y un modelo. En nuestro proyecto en este caso se le pasará al constructor una instancia de `GestorPersistencia`. Es importante que sea el controlador el que gestione los eventos de la vista y las acciones que se deberán ejecutar.

Para capturar y añadir un evento desde el controlador es de la siguiente forma:

```java
ActionListener buscarListener = actionEvent -> {
    // Aquí podemos programar las acciones que tiene que hacer la vista y el modelo o la persistencia
    gestorPersistencia.guardarCosas(vista.getCosas());
    vista.cerrarDialogo();
};
// Importante coger el botón de la vista y añadir ese action listener 
vista.getButtonOK().addActionListener(buscarListener);
```

Aquí hay que tener varias cosas en cuenta. El símbolo `->` indica una función lambda, que es algo nuevo de Java 8. Lo que hace es equivalente al siguiente código:

```java
buscarListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        buscar.cerrarDialogo();
    }
};
```

La siguiente cosa a tener en cuenta es `vista.getButtonOk()`. El objeto `vista` es la referencia que hemos pasado al constructor del controlador. 

```java
public AppControlador(App app, GestorPersistencia gestorPersistencia) {
    this.app = app;
    this.gestorPersistencia = gestorPersistencia;

    // Poner en este método todos los listeners de la vista
    this.iniciarListeners();
}
```

En este caso app es la vista. Cada controlador debe tener asociado una vista y un modelo o gestor de persistencia.

Por convención el controlador no tiene lógica más allá de la validación de datos, éste sirve como nexo entre base de datos / lógica de negocio y la vista y es el que dictamina que cuando ocurre x pasa y.

## Persistencia

### Gestor persistencia

El punto principal de la persistencia es el GestorPersistencia. Este gestor tiene referencias a los demás gestores de persistencias de cada elemento (Marcas, eficiencias y modelos).

Esto quiere decir que __no se debe instanciar__ los demás gestores de persistencia. Para acceder a ellos se usan los getter de GestorPersistencia.

### Daos

En los DAOs se estipulan las acciones que se pueden cometer sobre ese pojo. Por ejemplo en EficienciaDao se estipulan los siguientes métodos.

```java
public interface EficienciaDao {
    List<Eficiencia> getTodasEficiencias();
    Eficiencia getEficiencia(int id);
}
```

Lo que quiere decir que sobre la tabla Eficiencias se puede sólamente buscar.

Este patrón permite ver a golpe de vista qué operaciones son soportadas sobre esa tabla en concreto.

### Clases de Persistencia

Estas clases implementan los daos, y por tanto se programan aquí los métodos de para acceder la base de datos.


## Modelo

Aquí viven los POJOS y las demás clases que representen lógica del proyecto.

## Utils

En este paquete existirá las utilidades generales. Por regla general son métodos estáticos.
