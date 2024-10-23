package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Empleado {
    private Integer id_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private String cargo;
    private Double salario;
    private Date fecha_contratacion;
}
