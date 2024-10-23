package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Servicio {
    private Integer id_servicio;
    private String tipo_servicio;
    private Double costo;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo id_vehiculo;
    private Date fecha_servicio;
}
