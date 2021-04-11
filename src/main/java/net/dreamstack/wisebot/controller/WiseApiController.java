package net.dreamstack.wisebot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamstack.wisebot.domain.accounts.Accounts;
import net.dreamstack.wisebot.domain.profiles.Profile;
import net.dreamstack.wisebot.domain.rates.Rate;
import net.dreamstack.wisebot.service.DefaultWiseApiService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wise-bot")
@RequiredArgsConstructor
@Slf4j
public class WiseApiController {

    private final DefaultWiseApiService wiseApiService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/rates", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Rate> getLKRRates() {
        return wiseApiService.getExchangeRates("SGD", "LKR");
    }

    @GetMapping(path = "/profiles", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Profile> getProfile() {
        return wiseApiService.getProfiles();
    }

    @GetMapping(path = "/accounts", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Accounts> getAccounts() {
        return wiseApiService.getAccounts("LKR");
    }

}
