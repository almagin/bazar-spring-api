/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.Controller;

import es.yo.bazar.model.Producto;
import es.yo.bazar.service.IProductoService;
import java.util.ArrayList;
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
public class ProductoController {

    @Autowired
    private IProductoService prodServ;

    @PostMapping("/productos/crear")
    public void altaProducto(@RequestBody Producto prod) {
        prodServ.alta(prod);
    }

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        List<Producto> listaProductos;
        //listaProductos = new ArrayList();
        listaProductos = prodServ.listar();
        return listaProductos;
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto buscarProducto(@PathVariable Long codigo_producto) {
        Producto prod = prodServ.buscar(codigo_producto);
        return prod;
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void bajaProducto(@PathVariable Long codigo_producto) {
        prodServ.baja(codigo_producto);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public void modificarProducto( @PathVariable Long codigo_producto,
                                   @RequestBody Producto prod_modificado
                                 ) 
    {
        prodServ.modificar(codigo_producto, prod_modificado);
    }
    
    @GetMapping ("/productos/falta_stock")
    public List<Producto> listarStockBajo(){
        return prodServ.listarStockBajo();
    }
    
    
    
  
}
