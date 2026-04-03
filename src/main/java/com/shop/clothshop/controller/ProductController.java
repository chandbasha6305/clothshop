package com.shop.clothshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.clothshop.entity.Product;
import com.shop.clothshop.repository.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Add product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
        
    }
 // Delete product
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {

        productRepository.deleteById(id);

    }
 // Update product

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product updatedProduct) {

        Product product =
            productRepository.findById(id).orElse(null);

        if (product != null) {

            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setImage(updatedProduct.getImage());

            return productRepository.save(product);

        }

        return null;

    }
 // Upload Image

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file)
            throws IOException {

        // Absolute folder path (VERY IMPORTANT)

        String folder =
            "C:/uploads/";   // create this folder manually

        Path path = Paths.get(folder);

        if (!Files.exists(path)) {

            Files.createDirectories(path);

        }

        String fileName =
                file.getOriginalFilename();

        Path filePath =
                Paths.get(folder + fileName);

        Files.write(filePath, file.getBytes());

        return fileName;

    }

}