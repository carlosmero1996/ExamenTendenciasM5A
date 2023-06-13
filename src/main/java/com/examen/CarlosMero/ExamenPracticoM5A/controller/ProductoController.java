/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examen.CarlosMero.ExamenPracticoM5A.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examen.CarlosMero.ExamenPracticoM5A.service.ProductoServiceImpl;
import com.examen.CarlosMero.ExamenPracticoM5A.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author carlos
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProducto() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearRol(@RequestBody Producto p) {
        p.setSub_total(p.obtenerSubtotal(p.getCantidad(), p.getPrecio()));
        p.setPvp(p.obtenerdescuento(p.getSub_total(), p.getDescuento()));
        p.setSub_total1(p.obtenersubtotal2(p.getSub_total(), p.getIva()));
        p.setTotal(p.obtenersubtotal2(p.getSub_total(), p.getIva()));
        return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto u) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {
                producto.setCantidad(u.getCantidad());

                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
