package com.example.demo.account;

import com.example.demo.account.controller.form.AccountLoginForm;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountLoginTest {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Test
    @DisplayName("회원이 로그인 합니다.")
    void accountLogin(){

//        Account account = new Account("test@test.com","1111");
//        accountRepository.save(account);

        final String email = "test@test.com";
        final String password = "1111";

        AccountLoginForm accountLoginForm = new AccountLoginForm(email,password);
        Account checkAccountLogin = accountService.accountLogin(accountLoginForm);

        assertEquals(email, checkAccountLogin.getEmail());
        assertEquals(password, checkAccountLogin.getPassword());

    }

    @Test
    @DisplayName("회원이 다른 아이디로 로그인 합니다.")
    void wrongIdLogin(){

        final String email = "test@naver.com";
        final String password = "1111";

        AccountLoginForm accountLoginForm = new AccountLoginForm(email,password);
        Account checkAccountLogin = accountService.accountLogin(accountLoginForm);

        assertEquals(email, checkAccountLogin.getEmail());
        assertEquals(password, checkAccountLogin.getPassword());
    }

    @Test
    @DisplayName("회원이 다른 비밀번호로 로그인 합니다.")
    void wrongPasswordLogin(){

        final String email = "test@test.com";
        final String password = "2222";

        AccountLoginForm accountLoginForm = new AccountLoginForm(email,password);
        Account checkAccountLogin = accountService.accountLogin(accountLoginForm);

        assertEquals(email, checkAccountLogin.getEmail());
        assertEquals(password, checkAccountLogin.getPassword());

    }

}
