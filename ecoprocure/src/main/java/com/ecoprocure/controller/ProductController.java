package com.ecoprocure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecoprocure.entity.Product;
import com.ecoprocure.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService ps;

    @GetMapping
    public List<Product> getAllProducts() {
    return ps.getAllProducts();
}

    @GetMapping("/{id}")//get product by  id
    public Product getProductById(@PathVariable Integer id){
        return ps.getProductById(id);
    }

    @PostMapping//add new product
    public Product saveProduct(@RequestBody Product prod){
        return ps.saveProduct(prod);
    }

    @PutMapping("/{id}")//update
    public Product updaProduct(@PathVariable Integer id, @RequestBody Product prod){
        return ps.updateProduct(id, prod);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id){
        ps.deleteProduct(id);
        return "Product deleted Successfully!!";
    }
    
}
