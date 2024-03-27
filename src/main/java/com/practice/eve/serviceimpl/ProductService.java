package com.practice.eve.serviceimpl;

import com.practice.eve.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ProductService {
    Logger log= Logger.getLogger("logger");

    @Autowired
    private RedisTemplate redisTemplate;
    public static final String HASH_KEY = "product";

    public List<Product> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(String productId){
        return (Product) redisTemplate.opsForHash().get(HASH_KEY,productId);
    }

    public Product save(Product product){
        log.info("product added"+product.toString());
        redisTemplate.opsForHash().put(HASH_KEY, product.getProductId(),product);
        return product;
    }

    public Product findProductByCartId(String cartId){
        List values = redisTemplate.opsForHash().values(HASH_KEY);
        return (Product) values.stream().filter(p->((Product)p).getCartId().equals(cartId)).findFirst().get();
    }

    public String addProduct(Product product){
        Object Product = null;
        Object productId = null;
        redisTemplate.opsForHash().put(productId,HASH_KEY,Product);
        return "Product Added Successfully";
    }

    public String deleteProduct(String productId){
        redisTemplate.opsForHash().delete(HASH_KEY,productId);
        return "Product Deleted";
    }
}