package com.example.demo.account.service;

import com.example.demo.account.controller.AccountController;
import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.controller.form.AccountLoginForm;
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

        final Optional<Account> maybeAccount = accountRepository.findByUserToken(accountInfoForm.getUserToken());
        if(maybeAccount.isEmpty()){
            return null;
        }

        Account existAccount = maybeAccount.get();

        return existAccount;
    }

    // 로그인 기능
    @Override
    public Account accountLogin(AccountLoginForm accountLoginForm) {

        final Optional<Account> maybeAcoount = accountRepository.findByEmail(accountLoginForm.getEmail());
        if(maybeAcoount.isEmpty()){
            log.info("아이디가 없습니다.");
            return null;
        }
        Account account = maybeAcoount.get();

        if(account.getPassword().equals(accountLoginForm.getPassword())){
            log.info("로그인 성공");
            account.setUserToken(UUID.randomUUID().toString());
            accountRepository.save(account);
            return account;
        }

        log.info("비밀번호가 다릅니다.");
        return null;
    }
}
