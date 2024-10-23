package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Vehiculo;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @Query(value = "SELECT * FROM Vehículo WHERE anio_vehiculo = :anio_vehiculo", nativeQuery=true)
    List<Vehiculo> obtenerVehiculosPorAnio(@Param("anio_vehiculo") int anio_vehiculo);

}
