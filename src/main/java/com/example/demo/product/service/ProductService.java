package com.example.demo.product.service;

import com.example.demo.product.entity.Product;
import com.example.demo.product.service.form.ProductResponseForm;
import com.example.demo.product.service.form.RegistRequestform;

import java.util.List;

public interface ProductService {

    List<Product> requestList();

    Product regist(RegistRequestform requestform);

    ProductResponseForm requestProduct(Long productId);
}
