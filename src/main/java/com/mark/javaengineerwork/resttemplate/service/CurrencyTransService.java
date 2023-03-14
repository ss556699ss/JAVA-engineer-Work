package com.mark.javaengineerwork.resttemplate.service;

import com.mark.javaengineerwork.resttemplate.model.CoinDesk;
import com.mark.javaengineerwork.resttemplate.model.Time;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface CurrencyTransService {

    CoinDesk getForCoinDesk();
    Time getCurrencyTime();
    Map<String, Bpi> getCurrencyBpi();

}
