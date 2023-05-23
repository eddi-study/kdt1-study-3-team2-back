package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.entity.Account;

public interface AccountService {
    Account regist(AccountRegistRequestForm requestForm);
}
