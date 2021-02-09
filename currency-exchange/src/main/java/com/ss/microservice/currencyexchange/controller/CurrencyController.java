package com.ss.microservice.currencyexchange.controller;


import com.ss.microservice.currencyexchange.bean.CurrencyExchange;
import com.ss.microservice.currencyexchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;


    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrenyExchangeRate(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange=currencyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange==null)
            throw new RuntimeException();

        //CurrencyExchange currencyExchange=new CurrencyExchange(1,from,to,currencyExchange.getConversionMultiple());
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

}
