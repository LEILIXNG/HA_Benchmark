package com.northwind.vendorcapture.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceResolver {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceResolver.class);
    private String pendingShipment;

    public static void translate(String value) {
        LOG.debug("接收到一次供应商处理请求");
        InvoiceResolver self = new InvoiceResolver();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("detail", value);
        String tariffRef101 = tariffRef101Attrs.get("detail");
        String ledgerEntry102 = String.valueOf(tariffRef101);
        this.pendingShipment = ledgerEntry102;
        forward();
    }

    private void forward() {
        String channelTag103 = this.pendingShipment;
        String catalogKey104 = new StringBuilder(channelTag103).toString();
        this.pendingShipment = catalogKey104;
        assemble();
    }

    private void assemble() {
        String receiptKey105 = this.pendingShipment;
        List<String> accountRef106Attrs = new ArrayList<String>();
        accountRef106Attrs.add("web");
        accountRef106Attrs.add(receiptKey105);
        String accountRef106 = accountRef106Attrs.get(1);
        final String voucherRef107 = accountRef106;
        ShipmentFetcher.translate(voucherRef107);
    }
}
