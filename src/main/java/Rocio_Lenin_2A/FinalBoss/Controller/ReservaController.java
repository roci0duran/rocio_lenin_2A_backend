package Rocio_Lenin_2A.FinalBoss.Controller;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import Rocio_Lenin_2A.FinalBoss.Entities.Reservas.ReservasEntity;
import Rocio_Lenin_2A.FinalBoss.Services.ClienteService;
import Rocio_Lenin_2A.FinalBoss.Services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin
public class ReservaController {
    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<ReservasEntity>> listar(){
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservasEntity> obtener(@PathVariable Long id){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ReservasEntity> crear(@RequestBody ReservasEntity reservas) {
        return new ResponseEntity<>(service.guardar(reservas), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservasEntity> actualizar(@PathVariable Long id, @RequestBody ReservasEntity reservas){
        return ResponseEntity.ok(service.actualizar(id, reservas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    }
