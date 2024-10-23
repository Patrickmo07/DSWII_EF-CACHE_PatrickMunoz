package pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Cliente;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.model.Empleado;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.repository.ClienteRepository;
import pe.edu.cibertec.DSWII_EF_CACHE_PatrickMunoz.service.IClienteService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {
    private final ClienteRepository clienteRepository;

    @Cacheable(value = "CliId", key = "id_cliente")
    @Override
    public List<Cliente> obtenerClientePorId(int id_cliente) {
        return clienteRepository.obtenerClientePorId(id_cliente);
    }

    @CacheEvict(value = "CliId", allEntries = true)
    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @CachePut(value = "CliId", key = "#cliente.id_cliente")
    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(cliente.getId_cliente()).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNombre_cliente(cliente.getNombre_cliente());
            clienteExistente.setApellido_cliente(cliente.getApellido_cliente());
            clienteExistente.setCorreo_electronico(cliente.getCorreo_electronico());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setTelefono(cliente.getTelefono());
            return clienteRepository.save(clienteExistente);
        }
        return null;
    }

    @CacheEvict(value = "CliId", allEntries = true)
    @Override
    public void quitarCliente(Integer id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }

    @CacheEvict(value = "CliId", allEntries = true)
    @Override
    public void eliminarCache() {

    }
}