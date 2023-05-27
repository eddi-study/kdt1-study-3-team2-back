package kr.eddi.demo.order.service.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRequestForm {
    final private Long productId;
    final private String userToken;
}
