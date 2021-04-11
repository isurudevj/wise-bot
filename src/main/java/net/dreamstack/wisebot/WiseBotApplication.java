package net.dreamstack.wisebot;

import net.dreamstack.wisebot.setting.TransferSetting;
import net.dreamstack.wisebot.setting.WiseSetting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties({
        WiseSetting.class,
        TransferSetting.class
    }
)
public class WiseBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiseBotApplication.class, args);
    }
}
