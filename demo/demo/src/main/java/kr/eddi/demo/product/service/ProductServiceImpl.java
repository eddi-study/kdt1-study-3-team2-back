package kr.eddi.demo.product.service;

import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.repository.ProductRepository;
import kr.eddi.demo.product.service.form.ProductResponseForm;
import kr.eddi.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    final AccountRepository accountRepository;

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
