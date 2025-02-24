package com.rk.employeeCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        // return "plain-login";
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage() {

        // return "plain-login";
        return "access-denied";
    }
}
