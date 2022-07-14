package com.devsuperior.dsmeta.controller

import com.devsuperior.dsmeta.entities.Sale
import com.devsuperior.dsmeta.services.SaleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sales")
class SaleController(
    private val saleService: SaleService
) {

    @GetMapping
    fun findSales(): List<Sale> {
        return saleService.findSales()
    }
}