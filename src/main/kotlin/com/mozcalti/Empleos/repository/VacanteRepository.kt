package com.mozcalti.Empleos.repository

import com.mozcalti.Empleos.model.Vacante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface VacanteRepository : JpaRepository<Vacante, UUID> {
    @Query("select v from Vacante v where v.perfil like concat('%',:query,'%') or v.fkEstado.nombre like concat('%',:estado,'%')")
    fun getList(@Param("query") query: String, @Param("estado") estado: String): List<Vacante>

}