package kr.eddi.demo.product.service;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.form.RegistRequestform;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> request();

    Product regist(List<MultipartFile> images,
            RegistRequestform requsetForm);

    public boolean writeImages(List<MultipartFile> images, Product product);
}
