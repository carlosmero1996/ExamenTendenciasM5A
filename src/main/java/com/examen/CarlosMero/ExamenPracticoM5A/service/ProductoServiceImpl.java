/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examen.CarlosMero.ExamenPracticoM5A.service;

import com.examen.CarlosMero.ExamenPracticoM5A.model.Producto;
import com.examen.CarlosMero.ExamenPracticoM5A.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements GenericService<Producto, Integer> {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return (CrudRepository<Producto, Integer>) productoRepository;
    }
}
