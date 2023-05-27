package kr.eddi.demo.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer productPrice;
    private String vendor;

    public Product(String productName, Integer productPrice, String vendor) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.vendor = vendor;
    }
}
