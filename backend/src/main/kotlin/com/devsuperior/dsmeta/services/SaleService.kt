package com.devsuperior.dsmeta.services

import com.devsuperior.dsmeta.entities.Sale
import com.devsuperior.dsmeta.repositories.SaleRepository
import org.springframework.stereotype.Service

@Service
class SaleService(
    private val saleRepository: SaleRepository
) {
    fun findSales(): List<Sale> {
        return saleRepository.findAll()
    }
}