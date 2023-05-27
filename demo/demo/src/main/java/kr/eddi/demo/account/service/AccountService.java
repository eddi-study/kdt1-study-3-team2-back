package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;

public interface AccountService {
    Account regist(AccountRegistRequestForm requestForm);

    Account login(AccoutLoginRequestForm requestForm);

    Boolean checkEmail(String email);
}
