package com.mark.javaengineerwork.resttemplate.service;

import com.mark.javaengineerwork.resttemplate.entity.Currency;
import com.mark.javaengineerwork.resttemplate.model.CoinDesk;
import com.mark.javaengineerwork.resttemplate.model.Time;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface CurrencyTransService {

    //呼叫外部API功能
    CoinDesk getForCoinDesk();
    //更新 coinDesk 的 API時間
    Time getCoinDeskTime();
    //取得 coinDesk 的 API幣別
    Map<String, Bpi> getCurrencyBpi();
    //查詢幣別
    Currency selectBpi(String currency);
    //更新幣別
    Currency updateBpi(Currency currency);
    //新增幣別
    Currency createBpi(Currency currency);
    //刪除幣別
    void deleteBpi(String currencyId);

}
