package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Orden;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    @Query(value = "SELECT * FROM Orden WHERE estado_orden = :estado_orden", nativeQuery=true)
    List<Orden> obtenerOrdenPorEstado(@Param("estado_orden") String estado_orden);

}
