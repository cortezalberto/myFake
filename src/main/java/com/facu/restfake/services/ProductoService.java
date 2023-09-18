package com.facu.restfake.services;


import com.facu.restfake.entities.Product;
import com.facu.restfake.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoService implements BaseService <Product>{

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    @Transactional
    public List<Product> findAll() throws Exception {
        try {

            List<Product> entities  =    productoRepository.findAll();

            return entities;

        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Product findById(Long id) throws Exception {
        try {
            /*Cuando realizo una Búsqueda tengo que tener en cuenta
       que tal vez mo esté ese registro en la base de datos.
Optional es una clase introducida en Java 8 que forma parte del
paquete java.util. Su propósito principal es ayudar a manejar
situaciones donde un valor puede estar presente o ausente,
sin necesidad de recurrir a la representación de valores nulos,
 lo que puede llevar a errores de NullPointerException.
 Optional se utiliza para expresar
explícitamente la posibilidad de que un valor sea nulo o no nulo.

   */
            Optional<Product > entityOptional   = productoRepository.findById(id);
// existe un método que se llama GET

            return entityOptional .get();

        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Product save(Product entity) throws Exception {
        try {
            System.out.println("En servicio " + entity.getDescription());


            entity = productoRepository.save(entity);
            System.out.println("En servicio " + entity.getId());


            return entity;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional

    public Product update(Long id, Product entity) throws Exception {
        try {
            Optional<Product > entityOptional  = productoRepository.findById(id);
// existe un método que se llama GET
            System.out.println("te muestro el id :" + entity.getId());

            Product producto =entityOptional .get();
            // Si existe la entidad la asigno a la variable persona y luego igual que Save

            producto = productoRepository.save(entity);

            return producto;

        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {

            if (productoRepository.existsById(id)) {

                productoRepository.deleteById(id);

                return true;

            }
            else {
                throw new Exception();
            }

        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
}


