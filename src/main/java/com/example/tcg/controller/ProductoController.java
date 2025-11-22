package com.example.tcg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tcg.model.Producto;
import com.example.tcg.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/productos")
@Tag    (name = "", description = "")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Listado de Productos Disponibles", description = "")
    public List<Producto>getAllProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por id", description = "")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir nuevo Producto", description = "")
    public Producto createProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar Producto Existente", description = "")
    public Producto updateProducto(@RequestBody Producto producto,@PathVariable Long id){
        Producto ProductoRegistrado = productoService.getProductoById(id);

        if(ProductoRegistrado != null){
            ProductoRegistrado.setFranquicia(producto.getFranquicia());
            ProductoRegistrado.setTipo(producto.getTipo());
            ProductoRegistrado.setNombreProduto(producto.getNombreProduto());
            ProductoRegistrado.setPrecio(producto.getPrecio());
            ProductoRegistrado.setDescripcion(producto.getDescripcion());
            ProductoRegistrado.setUrlImagen(producto.getUrlImagen());
            return productoService.saveProducto(ProductoRegistrado);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Producto", description = "") 
    public void deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
    }
}
