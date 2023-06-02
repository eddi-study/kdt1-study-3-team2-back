package kr.eddi.demo.accountTest;


import kr.eddi.demo.account.controller.form.AccountModifyRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class modifyTest {
    @Autowired
    AccountService accountService;

    @Test
    @DisplayName("회원 정보를 수정합니다.")
    void account_Modify(){
        final String email = "test@test.com";
        
        final String modifyEmail =  "test@naver.com";
        final String modifyPassword = "2222";

        AccountModifyRequestForm accountModifyRequestForm = new AccountModifyRequestForm(modifyEmail, modifyPassword);
        Account account = accountService.modify(email, accountModifyRequestForm);

        assertEquals(modifyEmail, account.getEmail());
        assertEquals(modifyPassword, account.getPassword());

    }

}
