package kr.eddi.demo.order.service.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderListRequestForm {
    @Getter
    private String userToken;

    public OrderListRequestForm(String userToken) {
        this.userToken = userToken;
    }
}
