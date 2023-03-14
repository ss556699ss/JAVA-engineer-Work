package com.mark.javaengineerwork.resttemplate.controller;

import com.mark.javaengineerwork.resttemplate.model.CoinDesk;
import com.mark.javaengineerwork.resttemplate.model.Time;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;
import com.mark.javaengineerwork.resttemplate.service.CurrencyTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping
public class CurrencyTransController {

    @Autowired
    public  CurrencyTransService currencyTransService;

    //取得json
    @GetMapping("/getForCoinDesk")
    public  ResponseEntity<CoinDesk> getForCoinDesk(){
        CoinDesk coinDesk = currencyTransService.getForCoinDesk();
        return  ResponseEntity.status(HttpStatus.OK).body(coinDesk);
    }

    //更新時間
    @GetMapping("/getCurrencyTime")
    public ResponseEntity<Time> getCurrencyTime(){
        Time time = currencyTransService.getCurrencyTime();
        return ResponseEntity.status(HttpStatus.OK).body(time);
    }

    //取得幣別
    @GetMapping("/getCurrencyBpi")
    public  ResponseEntity< Map<String, Bpi>> getCurrencyBpi(){
        Map<String, Bpi> currencyBpi = currencyTransService.getCurrencyBpi();
        return ResponseEntity.status(HttpStatus.OK).body(currencyBpi);
    }
}
