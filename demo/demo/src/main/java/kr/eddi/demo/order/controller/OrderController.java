package kr.eddi.demo.order.controller;

import kr.eddi.demo.order.service.OrderService;
import kr.eddi.demo.order.service.form.OrderRequestForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Slf4j
public class OrderController {
    final OrderService orderService;

    @PostMapping("/regist")
    public Long regist(@RequestBody OrderRequestForm requestForm) {
        log.info("order/");
        return orderService.regist(requestForm).getId();
    }
}
