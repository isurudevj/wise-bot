package net.dreamstack.wisebot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Profile {

    private String id;
    private String type;
    private Details details;

    @Data
    public static class Details {
        private String firstName;
        private String lastName;
        private String dateOfBirth;
        private String phoneNumber;
        private String avatar;
        private String occupation;
        private int primaryAddress;
    }
}
