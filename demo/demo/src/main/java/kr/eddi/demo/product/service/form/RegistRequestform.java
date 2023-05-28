package kr.eddi.demo.product.service.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.product.entity.Product;
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
    final String productDetails;

    public Product toProduct(Account account) {
        return new Product(this.productName, this.productPrice, account, this.productDetails);
    }
}
