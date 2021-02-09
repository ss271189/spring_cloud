package com.ss.microservice.currencyconvertor.controller;


import com.ss.microservice.currencyconvertor.model.CurrencyConversion;
import com.ss.microservice.currencyconvertor.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConvertorController {

    @Autowired
    Environment environment;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;


    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
 public CurrencyConversion convertCurrent(
         @PathVariable String from,
         @PathVariable String to,
         @PathVariable Integer quantity
    ){


        Map<String,String> uriProperties=new HashMap<>();
        uriProperties.put("from",from);
        uriProperties.put("to",to);
        ResponseEntity<CurrencyConversion> responseEntity =new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriProperties);

        CurrencyConversion cc=responseEntity.getBody();
        return new CurrencyConversion(cc.getId(),from,to,quantity,cc.getConversionMultiple(),cc.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)),cc.getEnvironment()  );
 }


    @GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrentFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Integer quantity
    ){
        CurrencyConversion cc=currencyExchangeProxy.getCurrencyConversion(from,to);
        return new CurrencyConversion(cc.getId(),from,to,quantity,cc.getConversionMultiple(),cc.getConversionMultiple().multiply(BigDecimal.valueOf(quantity)),cc.getEnvironment()  );
    }

}
