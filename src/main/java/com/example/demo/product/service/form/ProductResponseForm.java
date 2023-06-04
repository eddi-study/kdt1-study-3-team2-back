package com.example.demo.product.service.form;

import com.example.demo.product.entity.Product;
import lombok.Getter;


@Getter
public class ProductResponseForm {
    String productName;
    Integer productPrice;
    String productinfo;
    String account;
    Long productId;

    public ProductResponseForm(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productinfo = product.getProductinfo();
        this.account = product.getAccount().getEmail();
        this.productId = product.getId();
    }
}
