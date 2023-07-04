package com.mozcalti.Empleos.repository

import com.mozcalti.Empleos.model.Estado
import org.springframework.data.jpa.repository.JpaRepository

interface EstadoRepository : JpaRepository<Estado, Int> {

}