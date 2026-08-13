package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoprocure.entity.Product;
import com.ecoprocure.exception.ResourceNotFoundException;
import com.ecoprocure.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;


    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return prodRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product not found with ID: " + id));
    }

    public Product saveProduct(Product product) {
        return prodRepo.save(product);
    }

    public Product updateProduct(Integer id, Product product) {
        prodRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product not found with ID: " + id));
        product.setProductId(id);
        return prodRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        Product prod = prodRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product not found with ID: " + id));
        prodRepo.delete(prod);
    }
}