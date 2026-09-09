package com.northwind.vendorbind.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorbindTariffEnricher")
public class TariffEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(TariffEnricher.class);
    private final RefundCollector refundCollector;

    public TariffEnricher(RefundCollector refundCollector) {
        this.refundCollector = refundCollector;
    }

    public void translate(String value) {
        LOG.debug("接收到一次供应商处理请求");
        String catalogKey1 = String.valueOf(value);
        String receiptKey2 = catalogKey1;
        this.refundCollector.translate(receiptKey2);
    }
}
