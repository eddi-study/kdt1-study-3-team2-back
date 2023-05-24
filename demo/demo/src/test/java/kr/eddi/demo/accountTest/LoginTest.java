package kr.eddi.demo.accountTest;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginTest {
    @Autowired
    AccountService accountService;

    @Test
    @DisplayName("회원이 로그인을 시도합니다.")
    void member_try_login() {
        final String EMAIL = "test@test.com";
        final String PASSWORD = "password1";
        AccoutLoginRequestForm requestForm = new AccoutLoginRequestForm(EMAIL, PASSWORD);
        Account account = accountService.login(requestForm);

        assertEquals(EMAIL, account.getEmail());
        assertEquals(PASSWORD, account.getPassword());
        System.out.println(account.getUserToken());
    }
}
