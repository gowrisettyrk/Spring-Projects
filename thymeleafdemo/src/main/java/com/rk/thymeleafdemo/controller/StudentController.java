package com.rk.thymeleafdemo.controller;

import com.rk.thymeleafdemo.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${Countries}")
    private List<String> countries;

    @Value("${Languages}")
    private  List<String> languages;

    @Value("${Systems}")
    private List<String> systems;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/studentRegistration")
    public String studentRegistration(Model model){


        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @PostMapping("/studentFormProcess")
    public String studentFormProcess(@Valid @ModelAttribute("student") Student student,
                                     BindingResult theBindingResult,Model model) {

        if (theBindingResult.hasErrors()) {
            model.addAttribute("countries",countries);
            model.addAttribute("languages",languages);
            model.addAttribute("systems",systems);
            return "student-form";
        }
        else {
            return "student-confirmation";
        }
    }

}
