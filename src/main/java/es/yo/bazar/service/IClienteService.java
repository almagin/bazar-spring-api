/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.yo.bazar.service;

import es.yo.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {

//Alta
    public void alta(Cliente cli);
//Leer todo

    public List<Cliente> listar();
//Leer uno

    public Cliente buscar(Long id_cliente);
//Baja

    public void baja(Long id_cliente);
//Editar

    public void modificar(Long id_cliente, Cliente cli_modificado);
}
