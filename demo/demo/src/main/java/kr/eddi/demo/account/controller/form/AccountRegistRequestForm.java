package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountRegistRequestForm {
   final String email;
    final String password;

    public Account toAccount() {
        return new Account(this.email, this.password);
    }
}
