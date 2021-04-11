
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
public class Accounts {

        private List<Account> content;
        private Long size;
        private Sort sort;

}
