package kr.eddi.demo.product.service;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    @Override
    public List<Product> request() {
        log.info("request()");
        return productRepository.findAll();
    }
}
