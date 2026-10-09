package Rocio_Lenin_2A.FinalBoss.Repository;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {

    // Método personalizado automático (Query Method)
    Optional<ClientesEntity> findByID(Long id);
}
