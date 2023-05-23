package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    final AccountRepository accountRepository;
    @Override
    public Account regist(AccountRegistRequestForm requestForm) {
        Account account = requestForm.toAccount();
        System.out.println("account: " + account);

        Optional<Account> maybeAccount = accountRepository.findByEmail(account.getEmail());
        if(maybeAccount.isPresent()) {
            return null;
        }
        Account savedAccount = accountRepository.save(account);
        System.out.println(savedAccount);
        return savedAccount;
    }
}
