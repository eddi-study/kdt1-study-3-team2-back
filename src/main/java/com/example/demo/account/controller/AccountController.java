package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.controller.form.AccountRequestFrom;
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

    @PostMapping("/regist")
    public Account accountRegister(@RequestBody AccountRequestFrom requestFrom) {
        log.info("accountRegister()");
        return accountService.register(requestFrom);
    }

    // 로그인 된 계정 정보 확인
    @PostMapping("/{userToken}")
    public Account accountInfo(@PathVariable("userToken") AccountInfoForm accountInfoForm){

        log.info("AccountInfo ");
        Account callAccountList = accountService.accountInfo(accountInfoForm);

        log.info("AccountInfo : " + callAccountList);

        return callAccountList;
    }

}
