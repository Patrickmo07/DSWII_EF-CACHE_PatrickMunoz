package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service;

import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Cliente;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Vehiculo;

import java.util.List;

public interface IClienteService {
    List<Cliente> obtenerClientePorId(int id_cliente);

    Cliente agregarCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    void quitarCliente(Integer id_cliente);

    void eliminarCache();
}
