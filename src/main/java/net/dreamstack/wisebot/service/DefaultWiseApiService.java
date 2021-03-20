package net.dreamstack.wisebot.service;

import lombok.extern.slf4j.Slf4j;
import net.dreamstack.wisebot.domain.ExchangeRate;
import net.dreamstack.wisebot.domain.Profile;
import net.dreamstack.wisebot.setting.WiseSetting;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.retry.Repeat;

import java.time.Duration;

@Component
@Slf4j
public class DefaultWiseApiService implements  WiseApiService {

    private static final String PATH_EXCHANGE_RATES = "/v1/rates";
    private static final String PATH_PROFILE = "/v1/profiles";

    private final WiseSetting wiseSetting;
    private final WebClient webClient;
    private final String authorizationHeaderValue;

    public DefaultWiseApiService(WiseSetting wiseSetting) {
        this.wiseSetting = wiseSetting;
        webClient = WebClient.create(wiseSetting.getBaseUrl());
        authorizationHeaderValue = "Bearer " + wiseSetting.getToken();
    }

    @Override
    public Flux<ExchangeRate> getExchangeRates(String source, String target) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path(PATH_EXCHANGE_RATES)
                .queryParam("source", source)
                .queryParam("target", target)
                .build())
                .header(HttpHeaders.AUTHORIZATION, authorizationHeaderValue)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<ExchangeRate>() {
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

}
