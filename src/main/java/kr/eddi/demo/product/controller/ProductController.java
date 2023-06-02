package kr.eddi.demo.product.controller;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.ProductService;
import kr.eddi.demo.product.service.form.ProductResponseForm;
import kr.eddi.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {
    final ProductService productService;

    @GetMapping("/request-list")
    public List<Product> requestList() {
        return productService.requestList();
    }

    @PostMapping(value = "/register")
    public Long regist(@RequestBody RegistRequestform requestForm) {
        log.info("product regist()");
        log.info("requestForm");
        return productService.regist(requestForm).getId();
    }

    @GetMapping("/{productId}")
    public ProductResponseForm request(@PathVariable Long productId) {
        log.info("product()");
        return productService.requestProduct(productId);}
}
