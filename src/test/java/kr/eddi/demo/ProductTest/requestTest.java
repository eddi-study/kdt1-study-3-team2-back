package kr.eddi.demo.ProductTest;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.ProductService;
import kr.eddi.demo.product.service.form.RegistRequestform;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

@SpringBootTest
public class requestTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("회원이 ProductList를 요청합니다")
    void request_productList() {
        List<Product> productList= productService.requestList();
        System.out.println(productList);
    }

    @Test
    @DisplayName("회원이 상품을 등록합니다")
    void regist_product() {
        String USERTOKEN = "aad7dfaa-3434-468b-89f6-169e2609253d";
        String PRODUCTNAME = "BAG";
        Integer PRODUCTPRICE = 1000;
        String VENDOR = "JILL";

        RegistRequestform requsetForm = new RegistRequestform(USERTOKEN, PRODUCTNAME, PRODUCTPRICE, VENDOR);
        Product registedProduct = productService.regist(requsetForm);

        assertEquals(PRODUCTNAME, registedProduct.getProductName());
        assertEquals(PRODUCTPRICE, registedProduct.getProductPrice());
//        assertEquals(VENDOR, registedProduct.getVendor());


    }

}
