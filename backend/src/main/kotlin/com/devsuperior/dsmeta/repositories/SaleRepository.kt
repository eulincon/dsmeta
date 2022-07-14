package com.devsuperior.dsmeta.repositories

import com.devsuperior.dsmeta.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository

interface SaleRepository : JpaRepository<Sale, Long> {
}