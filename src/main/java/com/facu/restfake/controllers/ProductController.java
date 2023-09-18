package com.facu.restfake.controllers;




import com.facu.restfake.entities.Product;
import com.facu.restfake.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "fakestoreapi.com/products")

public class ProductController {
    // Inyectamos el servicio
    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findAll());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getOne( @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }



    /*
    @RequestBody se aplica al parámetro entidad del método crearEntidad.
     Cuando se recibe una solicitud POST en esta ruta,
     Spring Framework tomará automáticamente el contenido del cuerpo de la solicitud
     (que se espera que esté en
     un formato específico, como JSON) y lo convertirá en una instancia de la clase Entidad.

     En resumen, @RequestBody es una anotación clave en Spring Framework para manejar datos enviados en el cuerpo de las solicitudes HTTP, lo que facilita
     la deserialización de esos datos en objetos Java para su procesamiento en el servidor.
     */
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Product entity){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(productoService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error en post. Por favor intente mas tarde. \"}");
        }
    }









    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");
        }
    }

    @PutMapping("/{id}")


    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Product entity){


        try {

            return ResponseEntity.status(HttpStatus.OK).body(productoService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");
        }
    }










}
