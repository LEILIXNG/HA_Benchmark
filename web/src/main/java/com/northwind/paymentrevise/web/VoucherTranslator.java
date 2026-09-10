package com.northwind.paymentrevise.web;

import com.northwind.paymentrevise.service.ShipmentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentreviseVoucherTranslator")
public class VoucherTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherTranslator.class);
    private static String cachedInvoice;

    public void translate(String value) {
        LOG.debug("接收到一次支付处理请求");
        String batchTag1 = String.format("ref_%s", value);
        cachedInvoice = batchTag1;
        collect();
    }

    private void collect() {
        String orderRef2 = cachedInvoice;
        String quoteRef3 = String.format("ref_%s", orderRef2);
        ShipmentAdapter.forward(quoteRef3);
    }
}
