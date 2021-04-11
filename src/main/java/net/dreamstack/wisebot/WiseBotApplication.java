package net.dreamstack.wisebot;

import net.dreamstack.wisebot.setting.Transfers;
import net.dreamstack.wisebot.setting.WiseSetting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        WiseSetting.class,
        Transfers.class
    }
)
public class WiseBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiseBotApplication.class, args);
    }
}
