package com.mozcalti.Empleos.controller

import com.mozcalti.Empleos.service.EstadoService
import com.mozcalti.Empleos.service.VacanteService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*


@Controller
@RequestMapping("/vacante")
class VacanteController(
        private val vacanteService: VacanteService,
        private val estadoService: EstadoService
) {


    @GetMapping("")
    fun vacantes(
            model: Model,
            @RequestParam(name = "q", defaultValue = "") query: String,
            @RequestParam(name = "e", defaultValue = "") estado: String,
    ): String {

        model.addAttribute("titulo", "Vacantes")
        model.addAttribute("listaVacantes", vacanteService.listaVacantes(query, estado))

        for (i in vacanteService.listaVacantes(query, estado)){
            model.addAttribute("fechaEndias", ChronoUnit.DAYS.between(i.fechaPublicacion, LocalDateTime.now()))

        }


        return "vacantes/tabla-vacantes"
    }


    @GetMapping("/publicar")
    fun publicarVancante(
            model: Model
    ): String {

        model.addAttribute("titulo", "Publicar")
        return "vacantes/form-vacantes"
    }


}