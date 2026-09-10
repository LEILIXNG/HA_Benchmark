package com.northwind.ordercapture.web;

import com.northwind.ordercapture.service.LedgerRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("ordercaptureQuoteRegistry")
public class QuoteRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRegistry.class);
    private String pendingSession;
    private final LedgerRouter ledgerRouter;

    public QuoteRegistry(LedgerRouter ledgerRouter) {
        this.ledgerRouter = ledgerRouter;
    }

    public void normalize(String value) {
        LOG.debug("接收到一次订单处理请求");
        this.publish(value);
    }

    private void publish(String value) {
        final String shipmentCode101 = value;
        this.pendingSession = shipmentCode101;
        route();
    }

    private void route() {
        String manifestKey102 = this.pendingSession;
        String invoiceKey103 = "ref_".concat(manifestKey102);
        this.ledgerRouter.enrich(invoiceKey103);
    }
}
