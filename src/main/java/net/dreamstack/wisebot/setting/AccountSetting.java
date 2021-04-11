package net.dreamstack.wisebot.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountSetting {
    private HashMap<String, BorderlessAccount> borderless;
}
