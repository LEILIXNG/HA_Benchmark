package com.northwind.vendorsettlequeue.web;

import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorsettlequeueBatchEnricher")
public class BatchEnricher {
    private final QuoteGuard quoteGuard;

    public BatchEnricher(QuoteGuard quoteGuard) {
        this.quoteGuard = quoteGuard;
    }

    public void forward(String value) {
        String paymentTag1 = new StringBuilder(value).toString();
        String refundCode2 = "ref:" + paymentTag1 + ";";
        this.quoteGuard.register(refundCode2);
    }
}
