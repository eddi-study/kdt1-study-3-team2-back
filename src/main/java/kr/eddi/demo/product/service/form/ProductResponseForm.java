package kr.eddi.demo.product.service.form;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseForm {
    String productName;
    Integer productPrice;
    String productDetails;
    String account;

    public ProductResponseForm(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDetails = product.getProductDetails();
        this.account = product.getAccount().getEmail();
    }
}
