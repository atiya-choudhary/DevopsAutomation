package com.practice.eve.controller;

import com.practice.eve.entity.Product;
import com.practice.eve.serviceimpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
        return productService.findAll();
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId){
        return productService.findProductById(productId);
    }

    //for fetching cartId from redis server for feign call
    @GetMapping("/cart/{cartId}")
    public Product getProductByCartId(@PathVariable String cartId){
        return productService.findProductByCartId(cartId);
    }
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId){
        return productService.deleteProduct(productId);
    }
}