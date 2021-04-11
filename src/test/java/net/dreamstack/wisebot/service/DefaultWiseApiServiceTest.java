package net.dreamstack.wisebot.service;

import net.dreamstack.wisebot.domain.accounts.Accounts;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultWiseApiServiceTest {

    @Autowired
    private DefaultWiseApiService defaultWiseApiService;

    @Test
    void getExchangeRates() {

    }

    @Test
    void getProfiles() {
    }

    @Test
    void getAccounts() {
        Mono<Accounts> accountsMono = defaultWiseApiService.getAccounts("LKR");
        Accounts accounts = accountsMono.block();
        Assert.assertNotNull(accounts);
    }
}