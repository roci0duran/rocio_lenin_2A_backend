package Rocio_Lenin_2A.FinalBoss.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Data
@Getter
@Setter

public class ReservasDTO {
    private Long id;
    private Long id_clientes;
    private Long id_vehiculo;
    private Calendar fecha_reserva;
    private int cantidad_pasajeros;
    private int cantidad_dias;
    private String estado;
    private double total_pago;
}
