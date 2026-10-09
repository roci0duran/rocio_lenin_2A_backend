package Rocio_Lenin_2A.FinalBoss.Controller;

import Rocio_Lenin_2A.FinalBoss.Entities.Vehiculos.VehiculosEntity;
import Rocio_Lenin_2A.FinalBoss.Services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin
public class VehiculoController {

        @Autowired
        private VehiculoService service;

        @GetMapping
        public ResponseEntity<List<VehiculosEntity>> listar(){
            return ResponseEntity.ok(service.obtenerTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<VehiculosEntity> obtener(@PathVariable Long id){
            return ResponseEntity.ok(service.obtenerPorId(id));
        }

        @PostMapping
        public ResponseEntity<VehiculosEntity> crear(@RequestBody VehiculosEntity vehiculos) {
            return new ResponseEntity<>(service.guardar(vehiculos), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<VehiculosEntity> actualizar(@PathVariable Long id, @RequestBody VehiculosEntity vehiculos){
            return ResponseEntity.ok(service.actualizar(id, vehiculos));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
    }
