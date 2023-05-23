package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.Account;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccoutLoginRequestForm {
    final private String email;
    final private String password;

    public Account toAccount(){
        return new Account(email, password);
    }
}
