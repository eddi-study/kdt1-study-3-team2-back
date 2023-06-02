package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;

import java.util.List;

public interface AccountService {
    Account regist(AccountRegistRequestForm requestForm);

    Account login(AccoutLoginRequestForm requestForm);

    Boolean checkEmail(String email);

    List<Account> list();

    void delete(String email);
}
