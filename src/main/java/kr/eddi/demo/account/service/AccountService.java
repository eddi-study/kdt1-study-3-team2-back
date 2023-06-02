package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountModifyRequestForm;
import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccountLoginRequestForm;
import kr.eddi.demo.account.entity.Account;

import java.util.List;

public interface AccountService {
    Account regist(AccountRegistRequestForm requestForm);

    Account login(AccountLoginRequestForm requestForm);

    Boolean checkEmail(String email);

    List<Account> list();

    void delete(String email);

    Account modify(String email, AccountModifyRequestForm accountModifyRequestForm);
}
