package com.mozcalti.Empleos.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun home(model: Model) : String {
        model.addAttribute("titulo", "Bienvenido a el sistema de empleos")
        return "home";
    }
}