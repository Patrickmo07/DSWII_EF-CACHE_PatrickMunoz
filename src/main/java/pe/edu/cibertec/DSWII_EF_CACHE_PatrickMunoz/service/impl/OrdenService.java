package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Orden;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.repository.OrdenRepository;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service.IOrdenService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdenService implements IOrdenService {
    private final OrdenRepository ordenRepository;

    @Cacheable(value = "OrdenEst", key = "id_orden")
    @Override
    public List<Orden> obtenerOrdenPorEstado(String estado_orden) {
        return ordenRepository.obtenerOrdenPorEstado(estado_orden);
    }

    @CacheEvict(value = "OrdenEst", allEntries = true)
    @Override
    public Orden agregarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @CachePut(value = "OrdenEst", key = "#orden.id_orden")
    @Override
    public Orden actualizarOrden(Orden orden) {
        Orden ordenExistente = ordenRepository.findById(orden.getId_orden()).orElse(null);
        if (ordenExistente != null) {
            ordenExistente.setEstado_orden(orden.getEstado_orden());
            ordenExistente.setCantidad(orden.getCantidad());
            ordenExistente.setFecha_orden(orden.getFecha_orden());
            return ordenRepository.save(ordenExistente);
        }
        return null;
    }

    @CacheEvict(value = "OrdenEst", allEntries = true)
    @Override
    public void quitarOrden(Integer id_orden) {
        ordenRepository.deleteById(id_orden);
    }

    @CacheEvict(value = "OrdenEst", allEntries = true)
    @Override
    public void eliminarCache() {

    }
}
