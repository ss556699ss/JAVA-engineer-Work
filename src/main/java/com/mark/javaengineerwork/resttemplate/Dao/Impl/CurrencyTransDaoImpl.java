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


    //查詢幣別
    @Override
    public Currency selectBpi(String currency) {

        return  currencyTransRepository.findById(currency).orElse(null);
    }

    //更新幣別
    @Override
    public Currency updateBpi(Currency currency) {

        return currencyTransRepository.save(currency);
    }

    @Override
    public Currency createBpi(Currency currency) {
        return currencyTransRepository.save(currency);
    }

    @Override
    public void deleteBpi(String currencyId) {
        currencyTransRepository.deleteById(currencyId);
    }
}
