/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.Controller;

import es.yo.bazar.model.Producto;
import es.yo.bazar.model.Venta;
import es.yo.bazar.service.IVentaService;
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
public class VentaController {
    
    @Autowired
    private IVentaService venServ;
      
    @PostMapping ("/ventas/crear")
    public void alta(@RequestBody Venta ven ){
        System.out.println("------ 0 Controller Crear.Entramos en el controller Post Ventas");
        venServ.alta(ven);
    }
    
    @GetMapping ("/ventas")
    public List<Venta> listar(){
        return venServ.listar();
    }
    // Buscar por id
    @GetMapping ("/ventas/{codigo_venta}")
    public Venta buscar(@PathVariable Long codigo_venta){
        return venServ.buscar(codigo_venta);
    }
    
    @DeleteMapping ("/ventas/eliminar/{codigo_venta}")
    public void baja (@PathVariable Long codigo_venta){
        venServ.baja(codigo_venta);
    }
    
    @PutMapping ("/ventas/editar/{codigo_venta}")
    public void editar (@PathVariable Long codigo_venta,
                        @RequestBody Venta ven_modificada){
        venServ.modificar(codigo_venta, ven_modificada);
    }
    
    //Lista Productos de una venta
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public List<Producto> verProductos (@PathVariable Long codigo_venta){
        return venServ.verProductos(codigo_venta);
    }
    
    //Resultados del día 
    @GetMapping ("ventas/dia/{fecha_venta}")
    public String mostrarResultados (@PathVariable String fecha_venta)
    {
        String resultados = "El monto del día " + fecha_venta +
                        " es de: "+ venServ.calcularMontoVentas(fecha_venta)+
                        ". Y la cantidad total de ventas es de: "+ venServ.cantitadVentas(fecha_venta)+
                        ". ";
        
        return resultados;
    }
}
