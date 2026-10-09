package Rocio_Lenin_2A.FinalBoss.Services;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import Rocio_Lenin_2A.FinalBoss.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository repository;

    //CREATE
    public ClientesEntity guardar(ClientesEntity clientes) {
     return repository.save(clientes);
    }

    //READ ALL
    public List<ClientesEntity> obtenerTodos(){
        return repository.findAll();
    }

    //READ BY ID
    public ClientesEntity obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    //UPDATE
    public ClientesEntity actualizar(Long id, ClientesEntity detalles){
        ClientesEntity clientes = obtenerPorId(id);
        clientes.setNombre(detalles.getNombre());
        clientes.setApellido(detalles.getApellido());
        clientes.setCorreo(detalles.getEmail());
        clientes.setTelefono(detalles.getTelefono());
        clientes.setDireccion(detalles.getDireccion());
        return repository.save(clientes);
    }

    // DELETE (Eliminar)
    public void eliminar(Long id) {
        ClientesEntity clientes = obtenerPorId(id);
        repository.delete(clientes);
    }

}
