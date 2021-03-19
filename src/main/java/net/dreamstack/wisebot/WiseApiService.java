package net.dreamstack.wisebot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamstack.wisebot.domain.ExchangeRate;
import net.dreamstack.wisebot.setting.WiseSetting;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.retry.Repeat;

import java.time.Duration;

@Component
@RequiredArgsConstructor
@Slf4j
public class WiseApiService {

    private final WiseSetting wiseSetting;

    public Flux<ExchangeRate> getExchangeRates() {
        WebClient webClient = WebClient.create(wiseSetting.getBaseUrl());
        return webClient.get().uri(uriBuilder -> uriBuilder.path("/v1/rates")
                .queryParam("source", "SGD")
                .queryParam("target", "LKR")
                .build())
                .header("Authorization", "Bearer " + wiseSetting.getToken())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<ExchangeRate>() {
                })
                .retry()
                .repeatWhen(Repeat.times(Long.MAX_VALUE).fixedBackoff(Duration.ofSeconds(1)));
    }

}
