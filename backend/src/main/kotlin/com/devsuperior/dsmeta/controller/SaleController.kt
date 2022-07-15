package com.devsuperior.dsmeta.controller

import com.devsuperior.dsmeta.entities.Sale
import com.devsuperior.dsmeta.services.SaleService
import com.devsuperior.dsmeta.services.SmsService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sales")
class SaleController(
    private val saleService: SaleService,
    private val smsService: SmsService
) {

    @GetMapping
    fun findSales(
        pageable: Pageable,
        @RequestParam(value = "minDate", defaultValue = "") minDate: String,
        @RequestParam(value = "maxDate", defaultValue = "") maxDate: String
    ): Page<Sale> {
        return saleService.findSales(pageable, minDate, maxDate)
    }

    @GetMapping("/{id}/notification")
    fun notifySms(@PathVariable id: Long) {
        smsService.sendSms(id)
    }
}