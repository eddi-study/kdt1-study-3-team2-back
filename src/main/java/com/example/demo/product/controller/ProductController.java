package com.example.demo.product.controller;

import com.example.demo.product.entity.Product;
import com.example.demo.product.service.ProductService;
import com.example.demo.product.service.form.ProductResponseForm;
import com.example.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    final private ProductService productService;

    @GetMapping("/product-list")
    public List<Product> requestList() { return productService.requestList(); }

    @GetMapping("/{productId}")
    public ProductResponseForm request(@PathVariable Long productId) {
        log.info("product()");
        return productService.requestProduct(productId);
    }
}
