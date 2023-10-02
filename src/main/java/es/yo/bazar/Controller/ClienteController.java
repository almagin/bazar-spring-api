/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.Controller;

import es.yo.bazar.model.Cliente;
import es.yo.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService cliServ;
        
    @PostMapping ("/clientes/crear")
    public void altaCliente ( @RequestBody Cliente cli ){
        cliServ.alta(cli);
    }
    
    @GetMapping ("/clientes")
    public List<Cliente> listar (){
        return cliServ.listar();
    }
    
    @GetMapping ("/clientes/{id_cliente}")
    public Cliente cli (@PathVariable Long id_cliente){
        return cliServ.buscar(id_cliente);
    }
    
    @DeleteMapping ("/clientes/eliminar/{id_cliente}")
    public void baja(@PathVariable Long id_cliente){
        cliServ.baja(id_cliente);
    }
            
    @PutMapping ("/clientes/editar/{id_cliente}")
    public void editar(@PathVariable Long id_cliente,
                        @RequestBody Cliente cli_modificado  
    ){
        cliServ.modificar(id_cliente, cli_modificado);
    }
}
