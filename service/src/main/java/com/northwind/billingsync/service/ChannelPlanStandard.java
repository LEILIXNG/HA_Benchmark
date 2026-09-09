package com.northwind.billingsync.service;

import org.springframework.stereotype.Service;

/**
 * 账务的默认处理策略。
 */
@Service("billingsyncChannelPlanStandard")
public class ChannelPlanStandard implements ChannelPlan {
    private final LedgerBroker ledgerBroker;

    public ChannelPlanStandard(LedgerBroker ledgerBroker) {
        this.ledgerBroker = ledgerBroker;
    }

    @Override
    public void handle(String value) {
        this.ledgerBroker.enrich(value);
    }
}
