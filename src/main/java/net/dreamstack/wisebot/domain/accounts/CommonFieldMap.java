package net.dreamstack.wisebot.domain.accounts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommonFieldMap {

    private String accountNumberField;
    private String bankCodeField;
    private String branchCodeField;

}
