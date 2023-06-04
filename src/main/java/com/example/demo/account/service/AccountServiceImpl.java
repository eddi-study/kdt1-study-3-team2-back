package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.controller.form.AccountRequestFrom;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    final private AccountRepository accountRepository;

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

    // 회원 가입
    @Override
    public Account register(AccountRequestFrom requestFrom) {
        final Optional<Account> maybeAccount = accountRepository.findByEmail(requestFrom.getEmail());

        if (maybeAccount.isPresent()) {
            return null;
        }
        return accountRepository.save(requestFrom.toAccount());
    }
}
