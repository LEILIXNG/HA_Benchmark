package com.northwind.orderlookup.web;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("orderlookupTariffStrategyStandard")
public class TariffStrategyStandard implements TariffStrategy {
    private final RefundFacade refundFacade;

    public TariffStrategyStandard(RefundFacade refundFacade) {
        this.refundFacade = refundFacade;
    }

    @Override
    public void handle(String value) {
        this.refundFacade.translate(value);
    }
}
