package com.product.service.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.service.entity.Product;
import com.product.service.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existing.setProduct_name(updatedProduct.getProduct_name());
        existing.setPro_desc(updatedProduct.getPro_desc());
        existing.setProduct_price(updatedProduct.getProduct_price());
        return productRepo.save(existing);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}