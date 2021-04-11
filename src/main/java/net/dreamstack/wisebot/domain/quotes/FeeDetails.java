package net.dreamstack.wisebot.domain.quotes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FeeDetails {

    private BigDecimal discount;
    private Long partner;
    private BigDecimal payIn;
    private Long priceSetId;
    private BigDecimal transferwise;

}
