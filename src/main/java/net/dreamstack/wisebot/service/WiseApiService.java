package net.dreamstack.wisebot.service;

import net.dreamstack.wisebot.domain.ExchangeRate;
import net.dreamstack.wisebot.domain.Profile;
import reactor.core.publisher.Flux;

public interface WiseApiService {

    Flux<ExchangeRate> getExchangeRates(String source, String target);

    Flux<Profile> getProfiles();

}
