package com.northwind.paymentintake.web;

import com.northwind.paymentintake.service.QuoteAdapter;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("paymentintakeCatalogBroker")
public class CatalogBroker {
    private final QuoteAdapter quoteAdapter;

    public CatalogBroker(QuoteAdapter quoteAdapter) {
        this.quoteAdapter = quoteAdapter;
    }

    public void reconcile(String value) {
        String quoteRef1 = "ref:" + value + ";";
        final String tariffRef2 = quoteRef1;
        this.quoteAdapter.stage(tariffRef2);
    }
}
