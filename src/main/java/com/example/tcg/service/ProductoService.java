package com.example.tcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tcg.model.Producto;
import com.example.tcg.repository.ProductoRepository;



@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
    public Producto updateProducto(Long id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setFranquicia(producto.getFranquicia());
            existingProducto.setTipo(producto.getTipo());
            existingProducto.setNombreProduto(producto.getNombreProduto());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setUrlImagen(producto.getUrlImagen());
            return productoRepository.save(existingProducto);
        }
        return null;
    }
    
    


}
