package kr.eddi.demo.product.repository;

import kr.eddi.demo.product.entity.ProductImagePath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagePathRepository extends JpaRepository<ProductImagePath, Long> {
}
