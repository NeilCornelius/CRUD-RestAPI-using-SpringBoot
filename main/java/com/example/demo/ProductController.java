package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return product!=null? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id,product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product Deleted Successfully");
    }
}
