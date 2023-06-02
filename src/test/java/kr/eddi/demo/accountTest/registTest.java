package kr.eddi.demo.accountTest;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class registTest {
    @Autowired
    AccountService accountService;

    @Test
    @DisplayName("회원이 회원가입을 진행합니다")
    void Members_signup() {
        final String EMAIL = "test@test.com";
        final String PASSWORD = "password1";
        AccountRegistRequestForm accountRegistRequestForm = new AccountRegistRequestForm(EMAIL, PASSWORD);
        Account registedAccount = accountService.regist(accountRegistRequestForm);
        assertEquals(EMAIL, registedAccount.getEmail());
        assertEquals(PASSWORD, registedAccount.getPassword());

    }
}
