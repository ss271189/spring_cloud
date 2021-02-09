package com.ss.microservice.currencyexchange.repository;

import com.ss.microservice.currencyexchange.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Integer> {

    CurrencyExchange findByFromAndTo(String from,String to);
}
