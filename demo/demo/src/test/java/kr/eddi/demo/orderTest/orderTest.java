package kr.eddi.demo.orderTest;

import kr.eddi.demo.order.entity.Order;
import kr.eddi.demo.order.service.OrderService;
import kr.eddi.demo.order.service.form.OrderRequestForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class orderTest {
    @Autowired
    OrderService orderService;

    @Test
    @DisplayName("회원이 상품을 구매합니다")
    void member_product_order() {
        final Long PRODUCTID = 1L;
        final String USERTOKEN = "aad7dfaa-3434-468b-89f6-169e2609253d";

        OrderRequestForm requestForm = new OrderRequestForm(PRODUCTID, USERTOKEN);
        Order order = orderService.regist(requestForm);

        assertEquals(order.getProduct().getId(), PRODUCTID);

    }

}
