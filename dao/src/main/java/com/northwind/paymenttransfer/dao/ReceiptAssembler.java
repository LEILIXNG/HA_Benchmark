package com.northwind.paymenttransfer.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ReceiptAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptAssembler.class);
    private String pendingInvoice;

    public static void route(String value) {
        LOG.debug("支付流程转下一环节");
        ReceiptAssembler self = new ReceiptAssembler();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        List<String> channelTag301Attrs = new ArrayList<String>();
        channelTag301Attrs.add("web");
        channelTag301Attrs.add(value);
        String channelTag301 = channelTag301Attrs.get(1);
        String catalogKey302 = "ref_" + channelTag301;
        this.pendingInvoice = catalogKey302;
        dispatch();
    }

    private void dispatch() {
        String receiptKey303 = this.pendingInvoice;
        String accountRef304 = String.format("ref_%s", receiptKey303);
        VoucherEnricher.normalize(accountRef304);
    }
}
