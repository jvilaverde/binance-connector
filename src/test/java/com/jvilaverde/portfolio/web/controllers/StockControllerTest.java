package com.jvilaverde.portfolio.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvilaverde.portfolio.services.StockService;
import com.jvilaverde.portfolio.web.model.StockDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

@WebMvcTest(StockController.class)
class StockControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    StockService stockService;

    @Test
    void calculateAverageBuyingPrice() throws Exception {
//        given(stockService.calculateAverageStockBuyingPrice(getValidStockDto(), 20)).willReturn(125.0);
//
//        mockMvc.perform(
//                get("/api/v1/portfolio-management/average-buying-price").accept(MediaType.APPLICATION_JSON)
//        ).andExpect(status().isOk());
    }

    @Test
    void createStockWithTransactions() {
    }

    @Test
    void updateStockWithTransactions() {
    }

    @Test
    void deleteStock() {
    }

    StockDto getValidStockDto() {
        return StockDto.builder()
                .id(UUID.randomUUID())
                .ticker("AAPL")
                .name("Apple")
                .build();
    }
}