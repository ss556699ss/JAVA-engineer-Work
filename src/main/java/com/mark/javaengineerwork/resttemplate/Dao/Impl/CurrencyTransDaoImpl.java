package com.mark.javaengineerwork.resttemplate.Dao.Impl;

import com.mark.javaengineerwork.resttemplate.Dao.CurrencyTransDao;
import com.mark.javaengineerwork.resttemplate.repository.CurrencyTransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mark.javaengineerwork.resttemplate.entity.Currency;

@Component
public class CurrencyTransDaoImpl implements CurrencyTransDao {

    @Autowired
    CurrencyTransRepository currencyTransRepository;


    @Override
    public Currency selectBpi(Currency currency) {

        return  currencyTransRepository.findById(currency.getEn()).orElse(null);
    }
}
