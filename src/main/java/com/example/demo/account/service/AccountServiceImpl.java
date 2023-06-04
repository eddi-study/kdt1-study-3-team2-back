package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;

import java.util.Optional;
import java.util.UUID;

public class AccountServiceImpl implements AccountService{

    AccountRepository accountRepository;

    // 로그인 된 계정 정보 확인 기능
    @Override
    public Account accountInfo(AccountInfoForm accountInfoForm) {
        Optional<Account> maybeAccount = accountRepository.findByUserToken(accountInfoForm.getUserToken());

        if(maybeAccount.isEmpty()){
            return null;
        }

        Account existAccount = maybeAccount.get();

        return existAccount;
    }
}
