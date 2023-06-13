/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examen.CarlosMero.ExamenPracticoM5A.repository;

import com.examen.CarlosMero.ExamenPracticoM5A.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlos
 */

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "Select * from producto u where u.id_producto = :id_producto", nativeQuery = true)
    public Producto buscarProducto(int id_producto);
    
}
