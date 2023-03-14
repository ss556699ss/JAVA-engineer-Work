package com.mark.javaengineerwork.resttemplate.model.bpi;

import java.util.Map;

public class Bpi {
    public String code;
    public String symbol;
    public String rate;
    public String description;
    public String rate_float;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate_float() {
        return rate_float;
    }

    public void setRate_float(String rate_float) {
        this.rate_float = rate_float;
    }
}
