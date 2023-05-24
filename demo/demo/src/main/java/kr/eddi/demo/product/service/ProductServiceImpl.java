package kr.eddi.demo.product.service;

import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.repository.ProductRepository;
import kr.eddi.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final ProductRepository productRepository;
    final AccountRepository accountRepository;
    @Override
    public List<Product> request() {
        log.info("request()");
        return productRepository.findAll();
    }

    @Override
    public Product regist(RegistRequestform requsetForm) {
        log.info("/product/regist()");
        String userToken = requsetForm.getUserToken();
        Optional<Account> account = accountRepository.findByUserToken(userToken);
        if(account.isEmpty()){
            return null;
        }

        return productRepository.save(requsetForm.toProduct());
    }


}
