package kr.eddi.demo.account.controller;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    final AccountService accountService;

    @PostMapping("/regist")
    public Long regist(@RequestBody AccountRegistRequestForm requestForm) {
        log.info("regist()");
        Account account = accountService.regist(requestForm);
        if (account == null) {
            return null;
        }
        return account.getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody AccoutLoginRequestForm requestForm){
        log.info("login");
        Account account = accountService.login(requestForm);
        if (account == null) {
            return null;
        }
        return account.getUserToken();
    }
}
