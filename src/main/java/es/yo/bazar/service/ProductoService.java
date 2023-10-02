/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.service;

import es.yo.bazar.model.Producto;
import es.yo.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public void alta(Producto prod) {
        prodRepo.save(prod);
    }

    @Override
    public List<Producto> listar() {
        return prodRepo.findAll();
    }

    @Override
    public Producto buscar(Long codigo_producto) {
        return prodRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void baja(Long codigo_producto) {
        prodRepo.deleteById(codigo_producto);
    }

    @Override
    public void modificar(Long codigo_producto, Producto prod_modificado) {

        Producto prod = this.buscar(codigo_producto);// el objeto puede ser null

        prod.setNombre(prod_modificado.getNombre());
        prod.setMarca(prod_modificado.getMarca());
        prod.setCosto(prod_modificado.getCosto());
        prod.setCantidad_disponible(prod_modificado.getCantidad_disponible());

        prodRepo.save(prod); // podemos crear con este método¿?

    }

    @Override
    public List<Producto> listarStockBajo() {
        List<Producto> listaProductos = this.listar();
        List<Producto> listaStockBajo = new ArrayList();
        
        for (Producto prod : listaProductos){
            if ( prod.getCantidad_disponible()<5){
                listaStockBajo.add(prod);
            }
        }
        
        return listaStockBajo;
    }
    
}
