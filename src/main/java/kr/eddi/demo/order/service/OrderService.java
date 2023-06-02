package kr.eddi.demo.order.service;

import kr.eddi.demo.order.entity.Order;
import kr.eddi.demo.order.service.form.OrderListRequestForm;
import kr.eddi.demo.order.service.form.OrderRequestForm;

import java.util.List;

public interface OrderService {
    Order regist(OrderRequestForm requestForm);

    List<Order> listup(OrderListRequestForm requestForm);
}