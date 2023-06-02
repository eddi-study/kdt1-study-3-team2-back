package kr.eddi.demo.order.service;

import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import kr.eddi.demo.order.entity.Order;
import kr.eddi.demo.order.repository.OrderRepository;
import kr.eddi.demo.order.service.form.OrderListRequestForm;
import kr.eddi.demo.order.service.form.OrderRequestForm;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    final AccountRepository accountRepository;
    final ProductRepository productRepository;
    @Override
    public Order regist(OrderRequestForm requestForm) {
        Optional<Account> maybeAccount = accountRepository.findByUserToken(requestForm.getUserToken());
        if(maybeAccount.isEmpty()) {
            return null;
        }
        Optional<Product> maybeProduct = productRepository.findById(requestForm.getProductId());
        if(maybeProduct.isEmpty()) {
            return null;
        }

        Order order = new Order(maybeProduct.get(), maybeAccount.get());
        return orderRepository.save(order);

    }

    @Override
    public List<Order> listup(OrderListRequestForm requestForm) {
        List<Order> orderList = orderRepository.findByUserToken(requestForm.getUserToken());
        return orderList;
    }
}
