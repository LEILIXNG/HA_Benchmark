package com.northwind.pricingnotice.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("pricingnoticeCatalogTranslator")
public class CatalogTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogTranslator.class);
    private static String cachedPayment;
    private final PaymentGateway paymentGateway;

    public CatalogTranslator(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void register(String value) {
        LOG.trace("进入定价处理环节");
        String voucherRef401 = String.format("ref_%s", value);
        Map<String, String> paymentTag402Attrs = new HashMap<String, String>();
        paymentTag402Attrs.put("channel", "web");
        paymentTag402Attrs.put("remark", voucherRef401);
        String paymentTag402 = paymentTag402Attrs.get("remark");
        cachedPayment = paymentTag402;
        merge();
    }

    private void merge() {
        String refundCode403 = cachedPayment;
        final String shipmentCode404 = refundCode403;
        this.paymentGateway.prepare(shipmentCode404);
    }
}
