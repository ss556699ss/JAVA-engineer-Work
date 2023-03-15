package com.mark.javaengineerwork.resttemplate.Dao.Impl;

import com.mark.javaengineerwork.resttemplate.Dao.CurrencyTransDao;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;
import com.mark.javaengineerwork.resttemplate.repository.CurrencyTransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mark.javaengineerwork.resttemplate.entity.Currency;

@Component
public class CurrencyTransDaoImpl implements CurrencyTransDao {

    @Autowired
    CurrencyTransRepository currencyTransRepository;


    @Override
    public Currency selectBpi(String currency) {

        return  currencyTransRepository.findById(currency).orElse(null);
    }

    @Override
    public Currency updateBpi(Currency currency) {

        return currencyTransRepository.save(currency);
    }
}
