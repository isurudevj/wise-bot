package net.dreamstack.wisebot.domain.quotes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuoteResponse {

    private List<String> allowedProfileTypes;
    private Long createdByUserId;
    private String createdTime;
    private String deliveryEstimate;
    private BigDecimal fee;
    private FeeDetails feeDetails;
    private Boolean guaranteedTargetAmount;
    private Long id;
    private Boolean ofSourceAmount;
    private Long profile;
    private BigDecimal rate;
    private String rateType;
    private String source;
    private BigDecimal sourceAmount;
    private String target;
    private BigDecimal targetAmount;
    private String type;

}
