/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.yo.bazar.service;

import es.yo.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
 //Alta
    public void alta(Producto prod);
//Leer todo
    public List<Producto> listar();
//Leer uno
    public Producto buscar(Long codigo_producto);
  //Baja
    public void baja(Long codigo_producto);
 //Editar
    public void modificar(Long codigo_producto, Producto prod_modificado);

    public List<Producto> listarStockBajo();

}
