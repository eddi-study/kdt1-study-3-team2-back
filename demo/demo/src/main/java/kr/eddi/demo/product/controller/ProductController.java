package kr.eddi.demo.product.controller;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @GetMapping("/requst-list")
    public List<Product> request() {
        return productService.request();
    }
}
