package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Cliente;


import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT * FROM Cliente WHERE id_cliente = :id_cliente", nativeQuery=true)
    List<Cliente> obtenerClientePorId(@Param("id_cliente") int id_cliente );

}
