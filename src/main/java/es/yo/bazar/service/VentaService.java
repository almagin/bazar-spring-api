/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.service;

import es.yo.bazar.model.Producto;
import es.yo.bazar.model.Venta;
import es.yo.bazar.repository.IProductoRepository;
import es.yo.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoService prodServ;
    
// Alta
    @Override
    public void alta(Venta ven) {
        System.out.println( "------ 1 Service Crear. save ven " + ven.toStringProductos() );
        ventaRepo.save(ven);
        
        ven.setTotal(totalCostoProductos(ven.getCodigo_venta()));
        
        ventaRepo.save(ven);
    }
    
    // Listar todo
    @Override
    public List<Venta> listar() {
        return ventaRepo.findAll();
    }
    // Buscar por id
    @Override
    public Venta buscar(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void baja(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    
//Editar por id Venta
    @Override
    public void modificar(Long codigo_venta, Venta ven_modificada) {
                
        Venta ven = buscar(codigo_venta);// buscamos la venta

        ven.setFecha_venta(ven_modificada.getFecha_venta());// fecha

        //Lista productos. Solo llenamos los IDs :
        ven.setListaProductos(ven_modificada.getListaProductos());
        
        ven.setUnCliente(ven_modificada.getUnCliente());
        
        System.out.println("------ 1 Service modificar antes de save. "+ ven.toStringProductos());
        ventaRepo.save(ven);
        
        ven.setTotal(totalCostoProductos(ven.getCodigo_venta()));
        
        ventaRepo.save(ven);
        System.out.println("------ 2 Service modificar. "+ ven.toStringProductos());
        
    }

    //Lista Productos de una venta
    @Override
    public List<Producto> verProductos(Long codigo_venta) {
        Venta ven = this.buscar(codigo_venta);
        
        return ven.getListaProductos();
    }

    @Override
    public String calcularMontoVentas(String fecha_venta) {
        LocalDate fecha = LocalDate.parse(fecha_venta);
        Double montoTotal = 0D;
        
        List<Venta> listaVentas = listar();
        for (Venta v : listaVentas){
            if (v.getFecha_venta().equals(fecha)){
                montoTotal = montoTotal + v.getTotal();
            }
        }
        
        return montoTotal.toString();
    }

    @Override
    public String cantitadVentas(String fecha_venta) {
        LocalDate fecha = LocalDate.parse(fecha_venta);
        Long cantVentas = 0L;
        List<Venta> listaVentas = listar();
        
        for (Venta v : listaVentas){
            if (v.getFecha_venta().equals(fecha)){
                cantVentas = cantVentas + 1;
            }
        }
        return cantVentas.toString();
    }

    @Override
    public Double totalCostoProductos(Long codigo_venta) {

        Venta ven = buscar(codigo_venta);

        Double sumaCostos = 0D;

        if (!ven.getListaProductos().isEmpty()) {

            List<Producto> listaProductos = ven.getListaProductos();
            System.out.println("------ 1 Service totalCostoProductos. " + ven.toStringProductos());

            for (Producto p : listaProductos) {

                if (p.getCosto() != null) {
                    // funciona después de modificar, pero no con alta
                    sumaCostos = sumaCostos + p.getCosto();
                    System.out.println("------ 2 Service totalCostoProductos. Costo desde venta: " + p.getCosto());

                } else {
                    // funciona con alta, tenemos que usar la dependencia de producto
                    Double costoProducto = prodServ.buscar(p.getCodigo_producto()).getCosto();
                    sumaCostos = sumaCostos + costoProducto;
                    System.out.println("------ 2 Service totalCostoProductos. Costo desde producto:" + costoProducto);
                }

            }
            System.out.println("------ 3 Service totalCostoProductos. Suma: " + sumaCostos);
        }

        return sumaCostos;
    }
    
    
    
}
