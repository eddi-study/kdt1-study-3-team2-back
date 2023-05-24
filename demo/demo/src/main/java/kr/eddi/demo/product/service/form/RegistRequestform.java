package kr.eddi.demo.product.service.form;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegistRequestform {
    final String userToken;
    final String productName;
    final Integer productPrice;
    final String vendor;

    public Product toProduct() {
        return new Product(this.productName, this.productPrice, this.vendor);
    }
}
