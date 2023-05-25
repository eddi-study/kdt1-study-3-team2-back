package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class AccountRegistRequestForm {
    String email;
    String password;

    public AccountRegistRequestForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account toAccount() {
        return new Account(this.email, this.password);
    }
}
