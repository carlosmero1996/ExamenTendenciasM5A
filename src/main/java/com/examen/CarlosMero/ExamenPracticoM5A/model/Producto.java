/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examen.CarlosMero.ExamenPracticoM5A.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author carlos
 */
@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;
    

    @Column(name = "cantidad")
    private double cantidad;

    @Column(name = "sub_total")
    private double sub_total;

    @Column(name = "descuento")
    private double descuento;

    @Column(name = "iva")
    private double iva = 0.12;

    @Column(name = "pvp")
    private double pvp;

    @Column(name = "sub_total1")
    private double sub_total1;
    
    @Column(name = "total")
    private double total;

   

    public double obtenerSubtotal(double cantidad, double precio) {
        sub_total = cantidad * precio;
        return sub_total;
    }

    public double obtenerdescuento(double sub_total, double descuento) {
        descuento = sub_total * descuento;
        return descuento;
    }

    public double obtenersubtotal2(double sub_total, double iva) {
        sub_total1=(sub_total*iva)+sub_total;
        return sub_total1;
    }
   
    
    public double obtenertotal(double sub_total, double iva){
        total=sub_total-sub_total;
        return total;
    }
}
