package kr.eddi.demo.order.service;

import kr.eddi.demo.order.entity.Order;
import kr.eddi.demo.order.service.form.OrderRequestForm;

public interface OrderService {
    Order regist(OrderRequestForm requestForm);
}
