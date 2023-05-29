package kr.eddi.demo.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kr.eddi.demo.account.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer productPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Account account;
    private String productDetails;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    final private List<ProductImagePath> imagePaths = new ArrayList<>();

    public Product(String productName, Integer productPrice, Account account, String productDetails) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.account = account;
        this.productDetails = productDetails;
    }

    public void addImage(ProductImagePath imagePath) {
        imagePaths.add(imagePath);
    }
}
