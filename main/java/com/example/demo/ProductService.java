package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.getReferenceById(id);
    }

    public Product updateProduct(Long id,Product updatedProduct){
        Product existingProduct = productRepository.getReferenceById(id);
        if(existingProduct!=null){
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(existingProduct);
        }
        else{
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
