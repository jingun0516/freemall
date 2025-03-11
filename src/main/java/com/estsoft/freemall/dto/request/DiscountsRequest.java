package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Discounts;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DiscountsRequest {
    private BigDecimal discountRate;
    private BigDecimal discountPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Discounts toEntity() {
        return Discounts.builder()
                .discountRate(discountRate)
                .discountPrice(discountPrice)
                .startDate(startDate)
                .endDate(endDate).build();
    }
}
