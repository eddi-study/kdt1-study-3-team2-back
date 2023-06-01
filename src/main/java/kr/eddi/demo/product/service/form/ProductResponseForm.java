package kr.eddi.demo.product.service.form;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseForm {
    String productName;
    Integer productPrice;

    public ProductResponseForm(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
    }
}
