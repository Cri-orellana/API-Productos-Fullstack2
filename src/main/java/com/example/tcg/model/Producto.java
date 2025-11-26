package com.example.tcg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String franquicia;
    private String tipo;
    private String nombreProduto;
    private Integer precio;
    private String descripcion;
    private String urlImagen;

    // Constructor vacío (Obligatorio para JPA)
    public Producto() {
    }

    // Constructor con argumentos
    public Producto(Long productId, String franquicia, String tipo, String nombreProduto, Integer precio,
            String descripcion, String urlImagen) {
        this.productId = productId;
        this.franquicia = franquicia;
        this.tipo = tipo;
        this.nombreProduto = nombreProduto;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    // Getters y Setters manuales
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreProduto() {
        return nombreProduto;
    }

    public void setNombreProduto(String nombreProduto) {
        this.nombreProduto = nombreProduto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}