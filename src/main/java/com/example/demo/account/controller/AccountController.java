package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.controller.form.AccountLoginForm;
import com.example.demo.account.entity.Account;
import com.example.demo.account.service.AccountService;
import com.example.demo.account.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    final AccountService accountService;

    // 로그인 된 계정 정보 확인
    @PostMapping("/{userToken}")
    public Account accountInfo(@PathVariable("userToken") AccountInfoForm accountInfoForm){

        log.info("AccountInfo ");
        Account callAccount = accountService.accountInfo(accountInfoForm);
        log.info("AccountInfo : " + callAccount);

        return callAccount;
    }

    // 로그인 기능
    @PostMapping("/AccountLogin")
    public void accountLogin(@RequestBody AccountLoginForm accountLoginForm){

        log.info(("AccountLogin "));
        Account callLogin = accountService.accountLogin(accountLoginForm);
        log.info("AccountLogin : " + callLogin);

    }
}
