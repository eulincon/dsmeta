package com.devsuperior.dsmeta.services

import com.devsuperior.dsmeta.entities.Sale
import com.devsuperior.dsmeta.repositories.SaleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@Service
class SaleService(
    private val saleRepository: SaleRepository
) {
    fun findSales(pageable: Pageable, minDate: String, maxDate: String): Page<Sale> {
        val today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())
        val min = if (minDate.isEmpty()) today.minusDays(365) else LocalDate.parse(minDate)
        val max = if (maxDate.isEmpty()) today else LocalDate.parse(maxDate)

        return saleRepository.findSales(min, max, pageable)
    }
}