package com.northwind.customeradjust.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentCollector {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCollector.class);
    private String pendingTariff;
    private static String cachedTariff;

    public static void stage(String value) {
        LOG.debug("接收到一次客户处理请求");
        PaymentCollector self = new PaymentCollector();
        self.collect(value);
    }

    private void collect(String value) {
        String voucherRef301 = new StringBuilder(value).toString();
        cachedTariff = voucherRef301;
        merge();
    }

    private void merge() {
        String paymentTag302 = cachedTariff;
        StringBuilder refundCode303Buffer = new StringBuilder("ref:");
        refundCode303Buffer.append(paymentTag302).append(";");
        String refundCode303 = refundCode303Buffer.toString();
        this.pendingTariff = refundCode303;
        attach();
    }

    private void attach() {
        String shipmentCode304 = this.pendingTariff;
        String manifestKey305 = String.valueOf(shipmentCode304);
        TariffExecutor.resolve(manifestKey305);
    }
}
