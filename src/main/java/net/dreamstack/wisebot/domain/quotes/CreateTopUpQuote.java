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
public class CreateTopUpQuote {

    private Long profile;
    private String rateType;
    private String source;
    private String target;
    private BigDecimal sourceAmount;
    private String type;

}
