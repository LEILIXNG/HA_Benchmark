package com.northwind.billingmanifest.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("billingmanifestReceiptEnricher")
public class ReceiptEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptEnricher.class);
    private static String cachedChannel;
    private final BatchPolicySelector batchPolicySelector;

    public ReceiptEnricher(BatchPolicySelector batchPolicySelector) {
        this.batchPolicySelector = batchPolicySelector;
    }

    public void resolve(String value) {
        LOG.debug("账务流程转下一环节");
        List<String> voucherRef201Attrs = new ArrayList<String>();
        voucherRef201Attrs.add("web");
        voucherRef201Attrs.add(value);
        String voucherRef201 = voucherRef201Attrs.get(1);
        List<String> paymentTag202Attrs = new ArrayList<String>();
        paymentTag202Attrs.add("web");
        paymentTag202Attrs.add(voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get(1);
        cachedChannel = paymentTag202;
        prepare();
    }

    private void prepare() {
        String refundCode203 = cachedChannel;
        StringBuilder shipmentCode204Buffer = new StringBuilder("ref:");
        shipmentCode204Buffer.append(refundCode203).append(";");
        String shipmentCode204 = shipmentCode204Buffer.toString();
        String manifestKey205 = new StringBuilder(shipmentCode204).toString();
        cachedChannel = manifestKey205;
        refine();
    }

    private void refine() {
        String invoiceKey206 = cachedChannel;
        String batchTag207 = new StringBuilder(invoiceKey206).toString();
        cachedChannel = batchTag207;
        merge();
    }

    private void merge() {
        String orderRef208 = cachedChannel;
        String quoteRef209 = orderRef208;
        final String tariffRef210 = quoteRef209;
        this.batchPolicySelector.submit(tariffRef210);
    }
}
