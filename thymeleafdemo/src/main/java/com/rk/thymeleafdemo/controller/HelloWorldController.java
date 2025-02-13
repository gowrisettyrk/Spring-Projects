package com.rk.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "hellworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processForm1")
    public String convertToUppercase(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = "Hi!" + theName.toUpperCase();
        model.addAttribute("message",theName);
        return "helloworld";
    }

    @RequestMapping("/processForm2")
    public String convertToUppercase1(@RequestParam("studentName") String theName, Model model){
        theName = "Hey!" + theName.toUpperCase();
        model.addAttribute("message",theName);
        return "helloworld";
    }
}
