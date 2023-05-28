package kr.eddi.demo.product.service;

import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.entity.ProductImagePath;
import kr.eddi.demo.product.repository.ProductRepository;
import kr.eddi.demo.product.service.form.RegistRequestform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
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
    public List<Product> request() {
        log.info("request()");
        return productRepository.findAll();
    }

    @Override
    public Product regist(List<MultipartFile> images,
                          RegistRequestform requestForm) {
        log.info("/product/regist()");
        String userToken = requestForm.getUserToken();
        Optional<Account> maybeAccount = accountRepository.findByUserToken(userToken);
        if (maybeAccount.isEmpty()) {
            return null;
        }
        log.info("\u001B[32m"+"Account: green"+"\u001B[0m");
        Product product = requestForm.toProduct(maybeAccount.get());
        log.info("Product: green");
        if (!writeImages(images, product)) {
            return null;
        }

        log.info("\u001B[32m"+"writeImage(): green"+"\u001B[0m");
        return productRepository.save(product);
    }

    public boolean writeImages(List<MultipartFile> images, Product product)  {
        log.info("writeImage()");

        for (MultipartFile image : images) {
            String originalFileName = image.getOriginalFilename();
            try {
                FileOutputStream writer = new FileOutputStream(
                        "./downloadedImageFiles/" + originalFileName
                );

                writer.write(image.getBytes());

                writer.close();
                product.addImage(new ProductImagePath(originalFileName));

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;
    }


}
