/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.yo.bazar.service;

import es.yo.bazar.model.Producto;
import es.yo.bazar.model.Venta;
import java.util.List;


public interface IVentaService {
    
//Alta
    public void alta(Venta ven);
//Leer todo

    public List<Venta> listar();
//Leer uno

    public Venta buscar(Long codigo_venta);
//Baja

    public void baja(Long codigo_venta);
//Editar

    public void modificar(Long codigo_venta, Venta ven_modificada);
    
// Service:    

    public List<Producto> verProductos(Long codigo_venta);

    public String calcularMontoVentas(String fecha_venta);

    public String cantitadVentas(String fecha_venta);
    
    public Double totalCostoProductos (Long codigo_venta);
}
