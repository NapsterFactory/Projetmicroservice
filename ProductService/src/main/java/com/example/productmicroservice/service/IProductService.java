package com.example.productmicroservice.service;

import com.example.productmicroservice.model.Product;

import java.util.List;

public interface IProductService {
    public Product addProduct(Product product);
    public void deleteProduct(Long id);
    public List<Product> getProducts();
    public Product getProductById(Long Id);
}
