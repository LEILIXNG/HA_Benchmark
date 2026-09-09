package com.northwind.accountreopen.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class QuoteAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteAssembler.class);
    private String pendingSession;

    public static void assemble(String value) {
        LOG.debug("开始整理账户字段");
        QuoteAssembler self = new QuoteAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        String voucherRef401 = value;
        this.pendingSession = voucherRef401;
        dispatch();
    }

    private void dispatch() {
        String paymentTag402 = this.pendingSession;
        String refundCode403 = paymentTag402;
        List<String> shipmentCode404Attrs = new ArrayList<String>();
        shipmentCode404Attrs.add("web");
        shipmentCode404Attrs.add(refundCode403);
        String shipmentCode404 = shipmentCode404Attrs.get(1);
        VoucherStrategySelector.collect(shipmentCode404);
    }
}
