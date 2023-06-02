package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.Account;
import lombok.RequiredArgsConstructor;


public class AccoutLoginRequestForm {
    public AccoutLoginRequestForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    final private String email;
    final private String password;

    public Account toAccount(){
        return new Account(email, password);
    }
}