package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Vehiculo;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.repository.VehiculoRepository;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service.IVehiculoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VehiculoService implements IVehiculoService {
    private final VehiculoRepository vehiculoRepository;

    @Cacheable(value = "VehAnio", key = "anio_vehiculo")
    @Override
    public List<Vehiculo> obtenerVehiculosxAnio(int anio_vehiculo) {
        return vehiculoRepository.obtenerVehiculosPorAnio(anio_vehiculo);
    }

    @CacheEvict(value = "VehAnio", allEntries = true)
    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @CachePut(value = "VehAnio", key = "#vehiculo.id_vehiculo")
    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculoExistente = vehiculoRepository.findById(vehiculo.getId_vehiculo()).orElse(null);
        if (vehiculoExistente != null) {
            vehiculoExistente.setModelo(vehiculo.getModelo());
            vehiculoExistente.setAnio_vehiculo(vehiculo.getAnio_vehiculo());
            vehiculoExistente.setTipo_batería(vehiculo.getTipo_batería());
            vehiculoExistente.setPrecio(vehiculo.getPrecio());
            vehiculoExistente.setAutonomía(vehiculo.getAutonomía());
            return vehiculoRepository.save(vehiculoExistente);
        }
        return null;
    }

    @CacheEvict(value = "VehAnio", allEntries = true)
    @Override
    public void quitarVehiculo(Integer id_vehiculo) {

    }

    @CacheEvict(value = "VehAnio", allEntries = true)
    @Override
    public void eliminarCache() {

    }


}

