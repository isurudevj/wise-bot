
package net.dreamstack.wisebot.domain.profiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

        private Details details;
        private Long id;
        private String type;

}
