package com.northwind.vendoradjust.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的默认处理策略。
 */
@Component("vendoradjustQuotePlanStandard")
public class QuotePlanStandard implements QuotePlan {
    private final ChannelEnricher channelEnricher;

    public QuotePlanStandard(ChannelEnricher channelEnricher) {
        this.channelEnricher = channelEnricher;
    }

    @Override
    public void handle(String value) {
        this.channelEnricher.prepare(value);
    }
}
