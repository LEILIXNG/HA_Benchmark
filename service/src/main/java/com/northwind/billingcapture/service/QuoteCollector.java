package com.northwind.billingcapture.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class QuoteCollector {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteCollector.class);
    private String pendingSession;

    public static void publish(String value) {
        LOG.trace("进入账务处理环节");
        QuoteCollector self = new QuoteCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("detail", value);
        String invoiceKey101 = invoiceKey101Attrs.get("detail");
        String batchTag102 = new StringBuilder(invoiceKey101).toString();
        this.pendingSession = batchTag102;
        assemble();
    }

    private void assemble() {
        String orderRef103 = this.pendingSession;
        String quoteRef104 = String.valueOf(orderRef103);
        this.pendingSession = quoteRef104;
        prepare();
    }

    private void prepare() {
        String tariffRef105 = this.pendingSession;
        List<String> ledgerEntry106Attrs = new ArrayList<String>();
        ledgerEntry106Attrs.add("web");
        ledgerEntry106Attrs.add(tariffRef105);
        String ledgerEntry106 = ledgerEntry106Attrs.get(1);
        String channelTag107 = ledgerEntry106;
        ContractFilter.enrich(channelTag107);
    }
}
