package com.mark.javaengineerwork.resttemplate.Dao;

import com.mark.javaengineerwork.resttemplate.entity.Currency;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;

public interface CurrencyTransDao {

    Currency selectBpi(String currency);
    Currency updateBpi(Currency currency);
}
