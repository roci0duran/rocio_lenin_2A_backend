package Rocio_Lenin_2A.FinalBoss.Entities.Reservas;

import Rocio_Lenin_2A.FinalBoss.Entities.Clientes.ClientesEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "reservas")
public class ReservasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservas")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClientesEntity clientes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo")
    private ClientesEntity vehiculo;

    @Column(name = "nombre_reserva", nullable = false)
    private String nombre;

    @Column(name = "fecha_reserva", nullable = false)
    private String fecha_reserva;

    @Column(name = "cantidad_pasajeros", nullable = false)
    private int cantidad_pasajeros;

    @Column(name = "cantidad_dias", nullable = false)
    private int cantidad_dias;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "total_pago", nullable = false)
    private double total_pago;

}