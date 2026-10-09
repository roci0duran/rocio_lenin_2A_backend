package Rocio_Lenin_2A.FinalBoss.Controller;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import Rocio_Lenin_2A.FinalBoss.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClientesEntity>> listar(){
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesEntity> obtener(@PathVariable Long id){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClientesEntity> crear(@RequestBody ClientesEntity clientes) {
        return new ResponseEntity<>(service.guardar(clientes), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesEntity> actualizar(@PathVariable Long id, @RequestBody ClientesEntity clientes){
        return ResponseEntity.ok(service.actualizar(id, clientes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
