package net.dreamstack.wisebot.domain.quotes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateQuote {

    private BigDecimal sourceAmount;
    private String source;
    private String target;
    private String rateType;

}
