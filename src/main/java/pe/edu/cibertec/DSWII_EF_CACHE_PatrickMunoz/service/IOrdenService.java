package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service;

import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Orden;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Vehiculo;

import java.util.List;

public interface IOrdenService {
    List<Orden> obtenerOrdenPorEstado(String estado_orden);

    Orden agregarOrden(Orden orden);

    Orden actualizarOrden(Orden orden);

    void quitarOrden(Integer id_orden);

    void eliminarCache();
}
