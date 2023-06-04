package com.example.demo.product.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.product.service.form.ProductResponseForm;
import com.example.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final AccountRepository accountRepository;
    final ProductRepository productRepository;

    @Override
    public List<Product> requestList() {
        log.info("request()");
        return productRepository.findAll();
    }

    @Override
    public Product regist(RegistRequestform requestForm) {
        log.info("/product/regist()");
        String userToken = requestForm.getUserToken();
        Optional<Account> maybeAccount = accountRepository.findByUserToken(userToken);
        if (maybeAccount.isEmpty()) {
            return null;
        }
        log.info("account: " + maybeAccount.get());
        Product product = requestForm.toProduct(maybeAccount.get());

        return productRepository.save(product);
    }



    @Override
    @Transactional
    public ProductResponseForm requestProduct(Long productId) {
        log.info(String.valueOf(productId));
        Optional<Product> maybeProduct = productRepository.findById(productId);
        if(maybeProduct.isEmpty()) {
            log.info("product is empty");
            return null;
        }
        log.info(String.valueOf(maybeProduct.get()));
        return new ProductResponseForm(maybeProduct.get());
    }
}
