package com.northwind.billingrenewal.service;

import org.springframework.stereotype.Service;

/**
 * 账务的默认处理策略。
 */
@Service("billingrenewalLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final OrderFacade orderFacade;

    public LedgerStrategyStandard(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @Override
    public void handle(String value) {
        this.orderFacade.prepare(value);
    }
}
