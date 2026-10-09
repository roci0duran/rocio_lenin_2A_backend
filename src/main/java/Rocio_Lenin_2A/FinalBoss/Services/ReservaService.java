package Rocio_Lenin_2A.FinalBoss.Services;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import Rocio_Lenin_2A.FinalBoss.Entities.Reservas.ReservasEntity;
import Rocio_Lenin_2A.FinalBoss.Repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservasRepository repository;

    //CREATE
    public ReservasEntity guardar(ReservasEntity reserva) {
        return repository.save(reserva);
    }

    //READ ALL
    public List<ReservasEntity> obtenerTodos() {
        return repository.findAll();
    }

    //READ BY ID
    public ReservasEntity obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservas no encontradas"));
    }

    //UPDATE
    public ReservasEntity actualizar(Long id, ReservasEntity detalles){
        ReservasEntity reservas = obtenerPorId(id);
        reservas.setId(detalles.getId());
        reservas.setNombre(detalles.getNombre());
        reservas.setFecha_reserva(detalles.getFecha_reserva());
        reservas.setCantidad_pasajeros(detalles.getCantidad_pasajeros());
        reservas.setCantidad_dias(detalles.getCantidad_dias());
        reservas.setEstado(detalles.getEstado());
        reservas.setTotal_pago(detalles.getTotal_pago());
        return repository.save(reservas);
    }

    // DELETE (Eliminar)
    public void eliminar(Long id) {
        ReservasEntity reservas = obtenerPorId(id);
        repository.delete(reservas);
    }

}

