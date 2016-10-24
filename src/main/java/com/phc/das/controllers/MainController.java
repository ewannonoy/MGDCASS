package com.phc.das.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "")
    public String root() {
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/**")
    public String admin() {
        return "admin/index";
    }

    @RequestMapping(value = "/normal/**")
    public String normal() {
        return "normal/index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("LOGIN");
        return "login/index";
    }
}
