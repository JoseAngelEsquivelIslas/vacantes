package com.mozcalti.Empleos.model.dto

import lombok.Data

@Data
data class VacanteDTO (
        val perfil: String,
        val descripcionVacante: String,
        val categoria: String,
        val horarioEntrada: String,
        val horarioSalida: String,
        val espacioTrabajo: String,
        val tipoContrato: String,
        val educacionMinimaRequerida: String,
        val rangoSalarial: String,
        val fkEstado: Int,
)