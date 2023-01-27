package com.jvilaverde.portfolio.web.controllers;

import com.jvilaverde.portfolio.services.StockService;
import com.jvilaverde.portfolio.web.model.StockDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/portfolio-management")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/average-buying-price")
    public ResponseEntity<Double> calculateAverageBuyingPrice(
            @RequestBody StockDto stockDto,
            @RequestParam(name = "numberOfSharesToSell") int numberOfSharesToSell) {
        return new ResponseEntity<>(
                stockService.calculateAverageStockBuyingPrice(stockDto, numberOfSharesToSell), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createStockWithTransactions(@Valid @RequestBody StockDto stockDto) {
        StockDto stock = stockService.createStockWithTransactions(stockDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/portfolio-management/" + stock.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{stockId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStockWithTransactions(
            @PathVariable("stockId") UUID stockId, @Valid @RequestBody StockDto stockDto) {
        stockService.updateStockWithTransactions(stockId, stockDto);
    }

    @DeleteMapping("/{stockId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStock(@PathVariable("stockId") UUID stockId) {
        stockService.deleteStock(stockId);
    }

}
