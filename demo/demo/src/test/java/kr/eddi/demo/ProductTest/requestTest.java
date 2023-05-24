package kr.eddi.demo.ProductTest;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class requestTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("회원이 ProductList를 요청합니다")
    void request_ProductList() {
        List<Product> productList= productService.request();
        System.out.println(productList);
    }

}
