package net.dreamstack.wisebot.domain;

/*
*
* {"rate":1.18821,"source":"EUR","target":"USD","time":"2021-03-19T14:02:41+0000"}
* */

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRate {
    private BigDecimal rate;
    private String source;
    private String target;
    private String time;
}
