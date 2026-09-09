package com.northwind.catalogverify.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class LedgerRouter {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRouter.class);
    private String pendingPayment;
    private static String cachedPayment;

    public static void submit(String value) {
        LOG.debug("商品流程转下一环节");
        LedgerRouter self = new LedgerRouter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        final String voucherRef101 = value;
        this.pendingPayment = voucherRef101;
        resolve();
    }

    private void resolve() {
        String paymentTag102 = this.pendingPayment;
        String refundCode103 = String.format("ref:%s;", paymentTag102);
        cachedPayment = refundCode103;
        translate();
    }

    private void translate() {
        String shipmentCode104 = cachedPayment;
        String manifestKey105 = shipmentCode104;
        PaymentEvaluator.route(manifestKey105);
    }
}
