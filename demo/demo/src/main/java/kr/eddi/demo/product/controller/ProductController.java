package kr.eddi.demo.product.controller;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.ProductService;
import kr.eddi.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {
    final ProductService productService;

    @GetMapping("/request-list")
    public List<Product> request() {
        return productService.request();
    }

    @PostMapping("/regist")
    public Long regist(RegistRequestform requestForm) {
        log.info("product regist()");
        return productService.regist(requestForm).getId();
    }
}
