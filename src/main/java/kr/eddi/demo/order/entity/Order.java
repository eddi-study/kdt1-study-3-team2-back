package kr.eddi.demo.order.entity;

import jakarta.persistence.*;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="product_order")
@NoArgsConstructor
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Order(Product product, Account account) {
        this.product = product;
        this.account = account;
    }
}