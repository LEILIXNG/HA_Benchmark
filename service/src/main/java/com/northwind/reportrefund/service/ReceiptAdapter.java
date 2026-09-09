package com.northwind.reportrefund.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptAdapter.class);
    private String pendingTariff;

    public static void translate(String value) {
        LOG.debug("接收到一次报表处理请求");
        ReceiptAdapter self = new ReceiptAdapter();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> receiptKey201Attrs = new LinkedHashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("detail", value);
        String receiptKey201 = receiptKey201Attrs.getOrDefault("detail", "");
        this.pendingTariff = receiptKey201;
        collect();
    }

    private void collect() {
        String accountRef202 = this.pendingTariff;
        String voucherRef203 = String.valueOf(accountRef202);
        this.pendingTariff = voucherRef203;
        register();
    }

    private void register() {
        String paymentTag204 = this.pendingTariff;
        String refundCode205 = new StringBuilder(paymentTag204).toString();
        PaymentTranslator.compose(refundCode205);
    }
}
