package com.example.todo.app.account;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.model.Account;
import com.example.todo.domain.service.userdetails.SampleUserDetails;

@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping
    public String view(
            @AuthenticationPrincipal SampleUserDetails userDetails, // (1)
            Model model) {
        Account account = userDetails.getAccount();
        model.addAttribute(account);
        return "account/view";
    }
}
