package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoprocure.entity.Product;
import com.ecoprocure.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;


    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return prodRepo.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return prodRepo.save(product);
    }

    public Product updateProduct(Integer id, Product product) {
        product.setProductId(id);
        return prodRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        prodRepo.deleteById(id);
    }
}