package com.jvilaverde.portfolio.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class StockDto {

    @Null
    private UUID id;
    @Null
    private Long version;
    @Null
    private Timestamp createdDate;
    @Null
    private Timestamp lastModifiedDate;

    @NotBlank
    private String ticker;
    @NotBlank
    private String name;
    private Set<TransactionDto> transactions;
    @PositiveOrZero
    private Double dividendYield;
}
