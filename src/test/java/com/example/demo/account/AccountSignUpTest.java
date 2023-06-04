package com.example.demo.account;

import com.example.demo.account.controller.form.AccountRequestFrom;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountSignUpTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("회원 가입 테스트")
    void 회원_가입_테스트 () {
        final String email = "test@test.com";
        final String password = "test";

        AccountRequestFrom requestFrom = new AccountRequestFrom(email, password);
        Account account = accountService.register(requestFrom);

        assertEquals(email, account.getEmail());
    }
}
