package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@Entity
@Table(name = "Orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_orden;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo id_vehiculo;
    private String fecha_orden;
    private String cantidad;
    private String estado_orden;
}
