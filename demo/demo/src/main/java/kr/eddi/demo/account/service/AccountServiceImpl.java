package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    final AccountRepository accountRepository;
    @Override
    public Account regist(AccountRegistRequestForm requestForm) {
        Account account = requestForm.toAccount();

        Optional<Account> maybeAccount = accountRepository.findByEmail(account.getEmail());
        if(maybeAccount.isPresent()) {
            return null;
        }
        Account savedAccount = accountRepository.save(account);
        System.out.println(savedAccount);
        return savedAccount;
    }

    @Override
    public Account login(AccoutLoginRequestForm requestForm) {
        Account account = requestForm.toAccount();
        Optional<Account> maybeAccount = accountRepository.findByEmail(account.getEmail());

        if(maybeAccount.isEmpty()){
            return null;
        }
        Account savedAccount = maybeAccount.get();
        if (savedAccount.getPassword().equals(account.getPassword())) {
            savedAccount.setUserToken(UUID.randomUUID().toString());
            return accountRepository.save(savedAccount);
        }
        return null;
    }

    @Override
    public Boolean checkEmail(String email) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(email);

        if (maybeAccount.isPresent()){
            return false;
        }else{
            return true;
        }

    }
}
