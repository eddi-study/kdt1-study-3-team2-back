package com.example.demo.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginForm {
    final private String email;
    final private String password;

}
