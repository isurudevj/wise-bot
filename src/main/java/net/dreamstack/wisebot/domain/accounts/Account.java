package net.dreamstack.wisebot.domain.accounts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private String accountSummary;
    private Boolean active;
    private CommonFieldMap commonFieldMap;
    private String country;
    private Long creatorId;
    private String currency;
    private Details details;
    private List<DisplayField> displayFields;
    private String email;
    private String hash;
    private Long id;
    private Boolean isDefaultAccount;
    private String legalEntityType;
    private String longAccountSummary;
    private Name name;
    private Boolean ownedByCustomer;
    private Long profileId;
    private String type;

}
