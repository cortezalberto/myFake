package com.facu.restfake.services;

import java.util.List;

public interface BaseService <E> {

  // creamos todos los métodos Abstractos

// Para listar todos los registros
    public List<E> findAll() throws Exception;
    // Para buscar un registro en la base de Datos, pasando un id como parámetro
    public E findById(Long id) throws Exception;
    // Grabo la entidad genérica
    public E save(E entity) throws Exception;
    // Actualizo una entidad, pero previo la debo buscar en la base de datos
    public E update(Long id, E entity) throws Exception;

    // Elimino un entidad y le paso un id como parámetro
    public boolean delete(Long id) throws Exception;

}
