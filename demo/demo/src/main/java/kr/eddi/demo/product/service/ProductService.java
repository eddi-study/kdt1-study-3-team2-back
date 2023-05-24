package kr.eddi.demo.product.service;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.form.RegistRequestform;

import java.util.List;

public interface ProductService {
    List<Product> request();

    Product regist(RegistRequestform requsetForm);
}
