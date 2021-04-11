
package net.dreamstack.wisebot.domain.profiles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Details {

        private String avatar;
        private String dateOfBirth;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private Long primaryAddress;


}
