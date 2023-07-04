package com.mozcalti.Empleos.service

import com.mozcalti.Empleos.model.Estado
import com.mozcalti.Empleos.repository.EstadoRepository
import org.springframework.stereotype.Service

@Service
class EstadoService(private val estadoRepository: EstadoRepository){
    fun listaEstados(): List<Estado> = estadoRepository.findAll().toList()

}