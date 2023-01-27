package com.jvilaverde.portfolio;

import com.jvilaverde.portfolio.domain.Stock;
import com.jvilaverde.portfolio.repositories.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockLoader implements CommandLineRunner {
    private final StockRepository stockRepository;

    public StockLoader(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (stockRepository.count() == 0) {
            stockRepository.save(Stock.builder()
                    .ticker("AAPL")
                    .name("Apple Inc.")
                    .dividendYield(1.5)
                    .build());
        }
        System.out.println("Loaded Stocks: " + stockRepository.count());
    }
}
