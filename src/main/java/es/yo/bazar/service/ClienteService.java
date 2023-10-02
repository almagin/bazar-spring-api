/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.service;

import es.yo.bazar.model.Cliente;
import es.yo.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public void alta(Cliente cli) {
        cliRepo.save(cli);
    }

    @Override
    public List<Cliente> listar() {
        return cliRepo.findAll();
    }

    @Override
    public Cliente buscar(Long id_cliente) {
        return cliRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public void baja(Long id_cliente) {
        cliRepo.deleteById(id_cliente);
    }

    @Override
    public void modificar(Long id_cliente, Cliente cli_modificado) {
        Cliente cli = this.buscar(id_cliente); // puede ser null !
        cli.setNombre(cli_modificado.getNombre());
        cli.setApellido(cli_modificado.getApellido());
        cli.setDni(cli_modificado.getDni());
        
        cliRepo.save(cli);// puede crear nuevo cuando cli es null?
    }
    
    
    
}
