package kr.eddi.demo.product.service.form;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class RegistRequestform {
    public RegistRequestform(String userToken, String productName, Integer productPrice, String vendor) {
        this.userToken = userToken;
        this.productName = productName;
        this.productPrice = productPrice;
        this.vendor = vendor;
    }

    final String userToken;
    final String productName;
    final Integer productPrice;
    final String vendor;

    public Product toProduct() {
        return new Product(this.productName, this.productPrice, this.vendor);
    }
}
