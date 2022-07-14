package com.devsuperior.dsmeta.entities

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_sales")
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long?,
    private val sellerName: String?,
    private val visited: Int?,
    private val deals: Int?,
    private val amount: Double?,
    private val date: OffsetDateTime?
)