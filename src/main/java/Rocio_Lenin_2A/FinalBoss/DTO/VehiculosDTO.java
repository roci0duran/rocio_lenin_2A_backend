package Rocio_Lenin_2A.FinalBoss.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VehiculosDTO {

    private Long id_vehiculo;
    private String marca;
    private String modelo;
    private int capacidad = 1;
    private double precio_dia;
    private String placa;

}
