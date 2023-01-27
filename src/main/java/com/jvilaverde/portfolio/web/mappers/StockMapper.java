package com.jvilaverde.portfolio.web.mappers;

import com.jvilaverde.portfolio.domain.Stock;
import com.jvilaverde.portfolio.web.model.StockDto;
import org.mapstruct.Mapper;

@Mapper
public interface StockMapper {

    StockDto stockToStockDto(Stock stock);

    Stock stockDtoToStock(StockDto stockDto);
}
