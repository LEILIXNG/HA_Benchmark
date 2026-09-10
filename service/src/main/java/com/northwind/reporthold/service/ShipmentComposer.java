package com.northwind.reporthold.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportholdShipmentComposer")
public class ShipmentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentComposer.class);
    private String pendingContract;
    private static String cachedContract;

    public void attach(String value) {
        LOG.debug("报表流程转下一环节");
        this.register(value);
    }

    private void register(String value) {
        String refundCode101 = "ref_" + value;
        cachedContract = refundCode101;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode102 = cachedContract;
        final String manifestKey103 = shipmentCode102;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("reference", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("reference");
        cachedContract = invoiceKey104;
        compose();
    }

    private void compose() {
        String batchTag105 = cachedContract;
        String orderRef106 = String.valueOf(batchTag105);
        cachedContract = orderRef106;
        route();
    }

    private void route() {
        String quoteRef107 = cachedContract;
        final String tariffRef108 = quoteRef107;
        String ledgerEntry109 = new StringBuilder(tariffRef108).toString();
        this.pendingContract = ledgerEntry109;
        collect();
    }

    private void collect() {
        String channelTag110 = this.pendingContract;
        String catalogKey111 = String.format("ref_%s", channelTag110);
        this.pendingContract = catalogKey111;
        resolve();
    }

    private void resolve() {
        String receiptKey112 = this.pendingContract;
        String accountRef113 = String.format("ref_%s", receiptKey112);
        InvoicePolicy.prepare(accountRef113);
    }
}
