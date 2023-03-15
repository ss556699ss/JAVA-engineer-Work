package com.mark.javaengineerwork.resttemplate.controller;

import com.mark.javaengineerwork.resttemplate.entity.Currency;
import com.mark.javaengineerwork.resttemplate.model.CoinDesk;
import com.mark.javaengineerwork.resttemplate.model.Time;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;
import com.mark.javaengineerwork.resttemplate.service.CurrencyTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    //更新 coinDesk 的 API時間
    @GetMapping("/getCurrencyTime")
    public ResponseEntity<Time> getCurrencyTime(){
        Time time = currencyTransService.getCurrencyTime();
        return ResponseEntity.status(HttpStatus.OK).body(time);
    }

    //取得 coinDesk 的 API幣別
    @GetMapping("/getCurrencyBpi")
    public  ResponseEntity< Map<String, Bpi>> getCurrencyBpi(){
        Map<String, Bpi> currencyBpi = currencyTransService.getCurrencyBpi();
        return ResponseEntity.status(HttpStatus.OK).body(currencyBpi);
    }

    //查詢幣別
    @GetMapping("/selectBpi/{en}")
    public ResponseEntity<Currency> selectBpi(@PathVariable  String en) {
        Currency Bpi = currencyTransService.selectBpi(en);
        if(Bpi !=null){
            return ResponseEntity.status(HttpStatus.OK).body(Bpi);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //更新幣別
    @PutMapping("/updateBpi/{en}")
    public ResponseEntity<Currency> updateBpi(@PathVariable  String en,
                                              @RequestBody Currency currency) {
        currency.setEn(en);
        Currency Bpi = currencyTransService.updateBpi(currency);
        return ResponseEntity.status(HttpStatus.OK).body(Bpi);
    }

    //新增幣別
    @PostMapping("/createBpi")
    public ResponseEntity<Currency> createBpi(@RequestBody  Currency currency) {
        Currency Bpi = currencyTransService.createBpi(currency);
        return ResponseEntity.status(HttpStatus.OK).body(Bpi);
    }

    //刪除幣別
    @DeleteMapping("/deleteBpi/{currencyId}")
    public String deleteBpi(@PathVariable  String currencyId) {
        currencyTransService.deleteBpi(currencyId);
        return "刪除成功";
    }
}
