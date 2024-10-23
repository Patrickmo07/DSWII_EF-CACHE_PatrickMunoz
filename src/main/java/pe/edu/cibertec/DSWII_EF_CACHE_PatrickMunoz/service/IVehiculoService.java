package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service;

import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<Vehiculo> obtenerVehiculosxAnio(int anio_vehiculo);

    Vehiculo agregarVehiculo(Vehiculo vehiculo);

    Vehiculo actualizarVehiculo(Vehiculo vehiculo);

    void quitarVehiculo(Integer id_vehiculo);

    void eliminarCache();
}
