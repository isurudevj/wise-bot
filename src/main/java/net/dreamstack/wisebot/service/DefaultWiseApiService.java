package net.dreamstack.wisebot.service;

import lombok.extern.slf4j.Slf4j;
import net.dreamstack.wisebot.domain.accounts.Accounts;
import net.dreamstack.wisebot.domain.profiles.Profile;
import net.dreamstack.wisebot.domain.quotes.CreateQuote;
import net.dreamstack.wisebot.domain.quotes.QuoteResponse;
import net.dreamstack.wisebot.domain.rates.Rate;
import net.dreamstack.wisebot.setting.WiseSetting;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.Duration;

@Component
@Slf4j
public class DefaultWiseApiService implements  WiseApiService {

    private static final String RATE_TYPE = "FIXED";

    private static final String PATH_EXCHANGE_RATES = "/v1/rates";
    private static final String PATH_PROFILE = "/v1/profiles";
    private static final String PATH_ACCOUNT = "/v2/accounts";
    private static final String PATH_QUOTES = "/v1/quotes";

    private final WiseSetting wiseSetting;
    private final WebClient webClient;
    private final String authorizationHeaderValue;

    public DefaultWiseApiService(WiseSetting wiseSetting) {
        this.wiseSetting = wiseSetting;
        webClient = WebClient.create(wiseSetting.getBaseUrl());
        authorizationHeaderValue = "Bearer " + wiseSetting.getToken();
    }

    @Override
    public Flux<Rate> getExchangeRates(String source, String target) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path(PATH_EXCHANGE_RATES)
                .queryParam("source", source)
                .queryParam("target", target)
                .build())
                .header(HttpHeaders.AUTHORIZATION, authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Rate>() {
                })
                .retry()
                .repeatWhen(Repeat.times(Long.MAX_VALUE).fixedBackoff(Duration.ofSeconds(1)));
    }

    @Override
    public Flux<Profile> getProfiles() {
        return webClient.get().uri(uriBuilder -> uriBuilder.path(PATH_PROFILE)
                .build())
                .header(HttpHeaders.AUTHORIZATION, authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Profile>() {
                })
                .retry();
    }

    @Override
    public Mono<Accounts> getAccounts(String currency) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path(PATH_ACCOUNT).build())
                .header(HttpHeaders.AUTHORIZATION, authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Accounts>() {
                });
    }

    @Override
    public Mono<QuoteResponse> getQuotes(String source, String target, BigDecimal sourceAmount) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path(PATH_QUOTES)
                .queryParam("source", source)
                .queryParam("target", target)
                .queryParam("sourceAmount", sourceAmount)
                .queryParam("rateType", RATE_TYPE)
                .build())
                .header(HttpHeaders.AUTHORIZATION, authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<QuoteResponse>() {
                });
    }

    @Override
    public Mono<QuoteResponse> createQuote(CreateQuote createQuote) {
        return webClient.post().uri(uriBuilder -> uriBuilder.path(PATH_QUOTES).build())
                .header(HttpHeaders.AUTHORIZATION, authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(createQuote)
                .retrieve().bodyToMono(new ParameterizedTypeReference<QuoteResponse>() {
                });
    }

}
