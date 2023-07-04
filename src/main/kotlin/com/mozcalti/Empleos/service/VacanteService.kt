package com.mozcalti.Empleos.service

import com.mozcalti.Empleos.model.Vacante
import com.mozcalti.Empleos.repository.VacanteRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class VacanteService(private val repository: VacanteRepository) {

    fun listaVacantes(query: String, estado: String): List<Vacante> = repository.getList(query, estado).toList()
    fun getVacante(id: UUID): Vacante = repository.findById(id).get()


    fun getDateDiference(fechaPublicacion: LocalDateTime) : Long{
        return ChronoUnit.DAYS.between(fechaPublicacion, LocalDateTime.now())
    }

}