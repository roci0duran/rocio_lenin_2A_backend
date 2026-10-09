package Rocio_Lenin_2A.FinalBoss.Services;

import Rocio_Lenin_2A.FinalBoss.Entities.Reservas.ReservasEntity;
import Rocio_Lenin_2A.FinalBoss.Entities.Vehiculos.VehiculosEntity;
import Rocio_Lenin_2A.FinalBoss.Repository.ReservasRepository;
import Rocio_Lenin_2A.FinalBoss.Repository.VehiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehiculoService {

    @Autowired
    private VehiculosRepository repository;

    //CREATE
    public VehiculosEntity guardar(VehiculosEntity vehiculos) {
        return repository.save(vehiculos);
    }

    //READ ALL
    public List<VehiculosEntity> obtenerTodos() {
        return repository.findAll();
    }

    //READ BY ID
    public VehiculosEntity obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservas no encontradas"));
    }

    //UPDATE
    public VehiculosEntity actualizar(Long id, VehiculosEntity detalles){
        VehiculosEntity vehiculos = obtenerPorId(id);
        vehiculos.setId(detalles.getId());
        vehiculos.setMarca(detalles.getMarca());
        vehiculos.setModelo(detalles.getModelo());
        vehiculos.setCapacidad(detalles.getCapacidad());
        vehiculos.setPrecio_dia(detalles.getPrecio_dia());
        vehiculos.setPlaca(detalles.getPlaca());
        return repository.save(vehiculos);
    }

    // DELETE (Eliminar)
    public void eliminar(Long id) {
        VehiculosEntity reservas = obtenerPorId(id);
        repository.delete(reservas);
    }

}
