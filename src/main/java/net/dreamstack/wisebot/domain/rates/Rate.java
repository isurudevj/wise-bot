
package net.dreamstack.wisebot.domain.rates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {

    private Double mRate;
    private String mSource;
    private String mTarget;
    private String mTime;

}
