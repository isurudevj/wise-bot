package net.dreamstack.wisebot.domain.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

    private String customerTransactionId;
    private Details details;
    private Long quote;
    private Double targetAccount;

}
