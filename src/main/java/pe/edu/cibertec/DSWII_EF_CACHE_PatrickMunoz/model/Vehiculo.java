package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vehiculo;
    private String modelo;
    private Integer anio_vehiculo;
    private String tipo_batería;
    private Double precio;
    private Integer autonomía;


}
