package com.mark.javaengineerwork.resttemplate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mark.javaengineerwork.resttemplate.entity.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
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

    @Autowired
    private ObjectMapper objectMapper;

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

    //查詢幣別
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

    //創建幣別
    @Transactional
    @Test
    public void createBpi() throws  Exception{
        Currency currency = new Currency();
        currency.setEn("TWD");
        currency.setZh("台幣");
        String json = objectMapper.writeValueAsString(currency);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/createBpi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.en",equalTo("TWD")))
                .andExpect(jsonPath("$.zh",equalTo("台幣")))
                .andReturn().getResponse().getContentAsString( StandardCharsets.UTF_8 );
    }

    //更新幣別
    @Test
    @Transactional
    public void updateBpi() throws  Exception{
        Currency currency = new Currency();
        currency.setZh("披索");
        String json = objectMapper.writeValueAsString(currency);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/updateBpi/{en}","USD")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.en",equalTo("USD")))
                .andExpect(jsonPath("$.zh",equalTo("披索")))
                .andReturn().getResponse().getContentAsString( StandardCharsets.UTF_8 );
    }

}