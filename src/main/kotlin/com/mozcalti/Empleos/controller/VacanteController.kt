package com.mozcalti.Empleos.controller

import com.mozcalti.Empleos.model.*
import com.mozcalti.Empleos.model.dto.VacanteDTO
import com.mozcalti.Empleos.service.EstadoService
import com.mozcalti.Empleos.service.VacanteService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime
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
            @RequestParam(name = "s", defaultValue = "SALARIO") salario: String,
            @RequestParam(name = "c", defaultValue = "CATEGORIA") categoria: String,
            @RequestParam(name = "t", defaultValue = "CONTRATO") tipoContrato: String,
            @RequestParam(name = "e", defaultValue = "ESTADOS") estado: String,
    ): String {

        model.addAttribute("titulo", "Vacantes")
        model.addAttribute("qryConsultado", query)
        model.addAttribute("listaVacantes", vacanteService.listaVacantes(
                query,
                salario,
                categoria,
                tipoContrato,
                estado,
        ))
        model.addAttribute("listaSalario", SalarioFiltro.values())
        model.addAttribute("salarioSelect", salario)
        model.addAttribute("listaFechas", FechaFiltro.values())
        model.addAttribute("fechaSelect", "Fecha")
        model.addAttribute("listaCategorias", CategoriasFiltro.values())
        model.addAttribute("categoriaSelect", categoria)
        model.addAttribute("listaTipoContratacion", TipoContratacionFiltro.values())
        model.addAttribute("contratacionSelect", tipoContrato)
        model.addAttribute("listaEstados", estadoService.listaEstados())
        model.addAttribute("estadoSelect", estado)

        return "vacantes/tabla-vacantes"
    }

    @GetMapping("/byFecha")
    fun filtroPorFecha(
            model: Model,
            @RequestParam(name = "f", defaultValue = "") fecha: LocalDateTime,
    ): String {

        model.addAttribute("titulo", "Vacantes")
        model.addAttribute("listaVacantes", vacanteService.listaVacantesByFecha(fecha))
        model.addAttribute("listaSalario", SalarioFiltro.values())
        model.addAttribute("salarioSelect", "Salario")
        model.addAttribute("listaFechas", FechaFiltro.values())
        model.addAttribute("fechaSelect", fecha)
        model.addAttribute("listaCategorias", CategoriasFiltro.values())
        model.addAttribute("categoriaSelect", "Categoria")
        model.addAttribute("listaTipoContratacion", TipoContratacionFiltro.values())
        model.addAttribute("contratacionSelect", "Contratacion")
        model.addAttribute("listaEstados", estadoService.listaEstados())
        model.addAttribute("estadoSelect", "Estados")

        return "vacantes/tabla-vacantes"
    }

    @GetMapping("/nueva")
    fun publicarVancante(
            model: Model,
    ): String {

        model.addAttribute("titulo", "Nueva Vacante")
        model.addAttribute("listaTipoContratacion", TipoContratacionFiltro.values())
        model.addAttribute("listaEducacionMinima", EducacionMinimaFiltro.values())
        model.addAttribute("listaCategoria", CategoriasFiltro.values())
        model.addAttribute("listaEspacioTrabajo", EspacioTrabajoFiltro.values())
        model.addAttribute("listaRangoSalarial", SalarioFiltro.values())
        model.addAttribute("listaEstado", estadoService.listaEstados())

        return "vacantes/form-vacantes"
    }

    @PostMapping("/nueva")
    fun nuevaVacante(model: Model, @ModelAttribute vacanteDTO: VacanteDTO): String {

        vacanteService.nuevaVacante(
            vacanteDTO.perfil,
            vacanteDTO.descripcionVacante,
            vacanteDTO.categoria,
            vacanteDTO.horarioEntrada,
            vacanteDTO.horarioSalida,
            vacanteDTO.espacioTrabajo,
            vacanteDTO.tipoContrato,
            vacanteDTO.educacionMinimaRequerida,
            vacanteDTO.rangoSalarial,
            vacanteDTO.fkEstado,
        )
        return "home"
    }


}