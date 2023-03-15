package com.mark.javaengineerwork.resttemplate.service.Impl;

import com.mark.javaengineerwork.resttemplate.Dao.CurrencyTransDao;
import com.mark.javaengineerwork.resttemplate.model.CoinDesk;
import com.mark.javaengineerwork.resttemplate.model.Time;
import com.mark.javaengineerwork.resttemplate.model.bpi.Bpi;
import com.mark.javaengineerwork.resttemplate.service.CurrencyTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mark.javaengineerwork.resttemplate.entity.Currency;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;


@Service
public class CurrencyTransServiceImpl implements CurrencyTransService {

    @Autowired
    CurrencyTransDao currencyTransDao;
    @Override
    public CoinDesk getForCoinDesk() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);
        CoinDesk coinDesk = restTemplate.getForObject(
                "https://api.coindesk.com/v1/bpi/currentprice.json",
                CoinDesk.class
        );
        return coinDesk;
    }

    //取得時間
    @Override
    public Time getCoinDeskTime() {
        Time time = new Time();
        OffsetDateTime odt = OffsetDateTime.parse(getForCoinDesk().getTime().getUpdatedISO());
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        time.setUpdatedISO(sdf.format(odt));
        return time;
    }

    //取得幣別
    @Override
    public  Map<String, Bpi> getCurrencyBpi() {
        return  getForCoinDesk().getBpi();
    }


    //查詢幣別
    @Override
    public Currency selectBpi(String currency) {

        return  currencyTransDao.selectBpi(currency);
    }

    //更新幣別
    @Override
    public Currency updateBpi(Currency currency) {
        return currencyTransDao.updateBpi(currency);
    }

    @Override
    public Currency createBpi(Currency currency) {
        return currencyTransDao.createBpi(currency);
    }

    @Override
    public void deleteBpi(String currencyId) {
         currencyTransDao.deleteBpi(currencyId);
    }
}
