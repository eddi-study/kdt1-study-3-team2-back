package kr.eddi.demo.account.controller;

import kr.eddi.demo.account.controller.form.AccountRegistRequestForm;
import kr.eddi.demo.account.controller.form.AccoutLoginRequestForm;
import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return account.getUserToken();
    }

    @GetMapping("/check-email/{email}")
    public Boolean checkEmail(@PathVariable("email") String email){
        log.info("check email : " + email);

        return accountService.checkEmail(email);
    }

    @GetMapping("/list")
    public List<Account> accountList(){
        log.info("  ");
        log.info("AccountList()");


        List<Account> returnedAccountList = accountService.list();

        log.info("returnedAccountList : " + returnedAccountList);


        return returnedAccountList;
    }



}
