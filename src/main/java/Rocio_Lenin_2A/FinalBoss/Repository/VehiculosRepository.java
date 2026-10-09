package Rocio_Lenin_2A.FinalBoss.Repository;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import Rocio_Lenin_2A.FinalBoss.Entities.Reservas.ReservasEntity;
import Rocio_Lenin_2A.FinalBoss.Entities.Vehiculos.VehiculosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculosRepository extends JpaRepository<VehiculosEntity, Long> {

    // Método personalizado automático (Query Method)
    Optional<ReservasEntity> findByID(Long id);
}