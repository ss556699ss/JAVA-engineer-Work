package com.mark.javaengineerwork.resttemplate.Dao;

import com.mark.javaengineerwork.resttemplate.entity.Currency;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;

public interface CurrencyTransDao {

    //查詢幣別
    Currency selectBpi(String currency);
    //更新幣別
    Currency updateBpi(Currency currency);
    //新增幣別
    Currency createBpi(Currency currency);
    //刪除幣別
    void  deleteBpi(String currencyId);
}
