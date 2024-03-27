package com.practice.eve.entity;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash("Product")
public class Product implements Serializable {

    @Id
    @Value("12345")
    private String productId;

    private String cartId;

    private String name;

    private int qty;

    private long price;
}