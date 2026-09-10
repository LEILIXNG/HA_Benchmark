package com.northwind.shippingnotice.web;

import com.northwind.shippingnotice.service.PaymentEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class PaymentTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentTranslator.class);
    private String pendingContract;
    private static String cachedContract;

    public static void dispatch(String value) {
        LOG.trace("进入发运处理环节");
        PaymentTranslator self = new PaymentTranslator();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey101 = value;
        String batchTag102 = String.valueOf(invoiceKey101);
        cachedContract = batchTag102;
        collect();
    }

    private void collect() {
        String orderRef103 = cachedContract;
        String quoteRef104 = new StringBuilder(orderRef103).toString();
        this.pendingContract = quoteRef104;
        assemble();
    }

    private void assemble() {
        String tariffRef105 = this.pendingContract;
        String ledgerEntry106 = "ref_" + tariffRef105;
        StringBuilder channelTag107Buffer = new StringBuilder("ref_");
        channelTag107Buffer.append(ledgerEntry106);
        String channelTag107 = channelTag107Buffer.toString();
        PaymentEnricher.register(channelTag107);
    }
}
