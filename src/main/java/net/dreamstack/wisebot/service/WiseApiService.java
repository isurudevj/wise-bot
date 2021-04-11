package net.dreamstack.wisebot.service;

import net.dreamstack.wisebot.domain.accounts.Accounts;
import net.dreamstack.wisebot.domain.profiles.Profile;
import net.dreamstack.wisebot.domain.quotes.CreateQuote;
import net.dreamstack.wisebot.domain.quotes.CreateTopUpQuote;
import net.dreamstack.wisebot.domain.quotes.QuoteResponse;
import net.dreamstack.wisebot.domain.rates.Rate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface WiseApiService {

    Flux<Rate> getExchangeRates(String source, String target);

    Flux<Profile> getProfiles();

    Mono<Accounts> getAccounts(String currency);

    Mono<QuoteResponse> getQuotes(String source, String target, BigDecimal sourceAmount);

    Mono<QuoteResponse> createQuote(CreateQuote createQuote);

    Mono<QuoteResponse> createTopUpQuote(CreateTopUpQuote createTopUpQuote);

}
