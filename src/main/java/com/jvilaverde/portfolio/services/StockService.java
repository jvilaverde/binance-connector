package com.jvilaverde.portfolio.services;

import com.jvilaverde.portfolio.web.model.StockDto;
import com.jvilaverde.portfolio.web.model.TransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toCollection;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {

    public double calculateAverageStockBuyingPrice(StockDto stock, int numberOfSharesToSell) {
        Set<TransactionDto> sortedTransactions = stock.getTransactions().stream()
                .sorted(Comparator.comparing(TransactionDto::getBoughtAtDateTime))
                .collect(toCollection(LinkedHashSet::new));

        double numerator = 0, denominator = 0;
        for (TransactionDto transaction : sortedTransactions) {
            double counter = denominator + transaction.getNumberOfShares();
            if (counter == numberOfSharesToSell) break;
            else if (counter < numberOfSharesToSell) {
                numerator += transaction.getPrice().doubleValue() * transaction.getNumberOfShares();
                denominator += transaction.getNumberOfShares();
            } else {
                double difference = numberOfSharesToSell - denominator;
                numerator += transaction.getPrice().doubleValue() * difference;
                denominator += difference;
            }
        }
        return numerator / denominator;
    }

    public StockDto createStockWithTransactions(StockDto stockDto) {
        return stockDto;
    }

    public void updateStockWithTransactions(UUID stockId, StockDto stockDto) {

    }

    public void deleteStock(UUID stockId) {
        log.info("Deleting stock with id: " + stockId);
    }
}
