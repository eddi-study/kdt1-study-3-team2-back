package kr.eddi.demo.product.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
public class ProductImagePath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagePath;

    public ProductImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
