package net.dreamstack.wisebot.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransferSetting {
    private long profileId;
    private AccountSetting accounts;
}
