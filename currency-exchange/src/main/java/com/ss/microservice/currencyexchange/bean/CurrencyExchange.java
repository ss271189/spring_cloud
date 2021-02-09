package com.ss.microservice.currencyexchange.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class CurrencyExchange {

   @javax.persistence.Id
   @GeneratedValue
   private Integer Id;
   @Column(name = "currency_from")
   private String from;
   @Column(name = "currency_to")
   private String to;
   private BigDecimal conversionMultiple;
   private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(Integer id, String from, String to, BigDecimal conversionMultiple) {
        Id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
