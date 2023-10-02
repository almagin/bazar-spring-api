/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.yo.bazar.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_producto;
    
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    

    public Producto() {
    }

    public Producto(String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", cantidad_disponible=" + cantidad_disponible + '}';
    }
    
    
}

