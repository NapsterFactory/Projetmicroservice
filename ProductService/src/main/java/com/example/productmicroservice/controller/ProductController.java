package com.example.productmicroservice.controller;

import com.example.productmicroservice.model.Product;
import com.example.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/")
    public Product AddProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable ("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        productService.deleteProduct(produitId);
    }


}
