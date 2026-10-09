package Rocio_Lenin_2A.FinalBoss.Entities.Clientes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "clientes")
public class ClientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    public static void setCorreo(String email) {

    }
}
