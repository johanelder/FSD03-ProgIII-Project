package com.example.SpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("admin/adminPanel")
    public String adminController(){
        return "/admin/adminPanel";
    }
}
