package com.mark.javaengineerwork.resttemplate.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    //查詢商品
    @Test
    public void selectBpi() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/selectBpi/{en}","USD");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.zh",equalTo("美元")))
                .andReturn().getResponse().getContentAsString( StandardCharsets.UTF_8 );;
    }



}