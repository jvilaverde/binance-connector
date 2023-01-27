package com.jvilaverde.portfolio.web.model;

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransactionDto {

    @Positive
    private Integer numberOfShares;

    @Positive
    private BigDecimal price;

    @Null
    //@JsonFormat(pattern="yyyy-MM-dd", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime boughtAtDateTime;
}
