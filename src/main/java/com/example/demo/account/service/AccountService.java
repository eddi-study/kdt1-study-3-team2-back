package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.entity.Account;

import java.util.UUID;

public interface AccountService {
    Account accountInfo(AccountInfoForm accountInfoForm);
}
