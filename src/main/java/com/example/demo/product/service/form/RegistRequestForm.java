package com.example.demo.product.service.form;

import com.example.demo.account.entity.Account;
import com.example.demo.product.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class RegistRequestform {
    @JsonProperty("accountToken")
    final String userToken;
    final String productName;
    final Integer productPrice;
    final String productInfo;

    public Product toProduct(Account account) {
        return new Product(this.productName, this.productPrice, account, this.productInfo);
    }
}
