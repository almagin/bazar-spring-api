/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.jpa.repository.Temporal;

@Getter @Setter
@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    
    private LocalDate fecha_venta;
    private Double total;
    
    // posee una lista de productos:
    @ManyToMany
    @JoinTable(
            name = "ventas_productos",
            joinColumns = @JoinColumn(name = "venta"), inverseJoinColumns = @JoinColumn (name = "producto")
    )
    private List<Producto> listaProductos;
    
    // solo un cliente asociado:
    @OneToOne
    // JoinColumn va al lado de fk.
    @JoinColumn (name = "cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

    public String toStringProductos() {
        return "Productos de la Venta ID:" + codigo_venta + ", totalCosto=" + total + ". ListaProductos=" + listaProductos.toString();
    }


    
    
    

}
