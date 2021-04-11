package net.dreamstack.wisebot.service;

import net.dreamstack.wisebot.domain.accounts.Accounts;
import net.dreamstack.wisebot.domain.profiles.Profile;
import net.dreamstack.wisebot.domain.rates.Rate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WiseApiService {

    Flux<Rate> getExchangeRates(String source, String target);

    Flux<Profile> getProfiles();

    Mono<Accounts> getAccounts(String currency);

}
