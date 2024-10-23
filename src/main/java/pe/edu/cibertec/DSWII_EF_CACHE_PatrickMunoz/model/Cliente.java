package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String correo_electronico;
    private String direccion;
    private String telefono;
}
