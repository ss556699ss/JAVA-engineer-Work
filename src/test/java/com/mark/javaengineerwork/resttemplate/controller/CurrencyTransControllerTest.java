package com.mark.javaengineerwork.resttemplate.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyTransControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //測試呼叫 coinDesk API
    @Test
    public void getForCoinDesk() throws  Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getForCoinDesk");

        MvcResult mvcResult= mockMvc.perform(requestBuilder)
                .andDo(print())
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString();
        System.out.println(" coinDesk API內容:" +body);
    }

    //測試呼叫 coinDesk資料轉換 API
    @Test
    public void getCoinDeskTime() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getCoinDeskTime");

        MvcResult mvcResult= mockMvc.perform(requestBuilder)
                .andDo(print())
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString();
        System.out.println(" coinDesk 資料轉換 API內容:" +body);
    }



}