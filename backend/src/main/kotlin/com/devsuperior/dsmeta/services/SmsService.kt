package com.devsuperior.dsmeta.services

import com.devsuperior.dsmeta.repositories.SaleRepository
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class SmsService(
    @Value("\${twilio.sid}")
    private val twilioSid: String? = null,
    @Value("\${twilio.key}")
    private val twilioKey: String? = null,
    @Value("\${twilio.phone.from}")
    private val twilioPhoneFrom: String? = null,
    @Value("\${twilio.phone.to}")
    private val twilioPhoneTo: String? = null,
    private val saleRepository: SaleRepository
) {
    fun sendSms(id: Long) {
        val sale = saleRepository.findById(id).get()
        val date = "${sale.date?.month}/${sale.date?.year}"
        val msg = "O Vendedor ${sale.sellerName} foi destaque em $date com um total de R$ ${
            String.format(
                "%.2f",
                sale.amount
            )
        }"

        Twilio.init(twilioSid, twilioKey)
        val to = PhoneNumber(twilioPhoneTo)
        val from = PhoneNumber(twilioPhoneFrom)
        val message: Message = Message.creator(to, from, msg).create()
        println(message.sid)
    }
}