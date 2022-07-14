package com.devsuperior.dsmeta.entities

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_sales")
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val sellerName: String?,
    val visited: Int?,
    val deals: Int?,
    val amount: Double?,
    val date: OffsetDateTime?
)