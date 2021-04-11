package net.dreamstack.wisebot.domain.accounts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sort {

    private Boolean empty;
    private Boolean sorted;
    private Boolean unsorted;

}
