package com.example.demo.account.controller.form;

import com.example.demo.account.entity.Account;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequestFrom {

    private String email;
    private String password;

    public AccountRequestFrom(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account toAccount() {
        return new Account(email, password);
    }
}
