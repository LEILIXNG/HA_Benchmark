package com.northwind.paymentbatch.web;

import com.northwind.paymentbatch.service.ReceiptCoordinator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentbatchRefundBuilder")
public class RefundBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(RefundBuilder.class);
    private String pendingReceipt;
    private static String cachedReceipt;
    private final ReceiptCoordinator receiptCoordinator;

    public RefundBuilder(ReceiptCoordinator receiptCoordinator) {
        this.receiptCoordinator = receiptCoordinator;
    }

    public void prepare(String value) {
        LOG.debug("支付流程转下一环节");
        this.submit(value);
    }

    private void submit(String value) {
        final String voucherRef1 = value;
        this.pendingReceipt = voucherRef1;
        register();
    }

    private void register() {
        String paymentTag2 = this.pendingReceipt;
        Map<String, String> refundCode3Attrs = new HashMap<String, String>();
        refundCode3Attrs.put("channel", "web");
        refundCode3Attrs.put("note", paymentTag2);
        String refundCode3 = refundCode3Attrs.get("note");
        cachedReceipt = refundCode3;
        collect();
    }

    private void collect() {
        String shipmentCode4 = cachedReceipt;
        String manifestKey5 = shipmentCode4;
        cachedReceipt = manifestKey5;
        stage();
    }

    private void stage() {
        String invoiceKey6 = cachedReceipt;
        Map<String, String> batchTag7Attrs = new HashMap<String, String>();
        batchTag7Attrs.put("channel", "web");
        batchTag7Attrs.put("note", invoiceKey6);
        String batchTag7 = batchTag7Attrs.get("note");
        this.pendingReceipt = batchTag7;
        enrich();
    }

    private void enrich() {
        String orderRef8 = this.pendingReceipt;
        Map<String, String> quoteRef9Attrs = new HashMap<String, String>();
        quoteRef9Attrs.put("channel", "web");
        quoteRef9Attrs.put("detail", orderRef8);
        String quoteRef9 = quoteRef9Attrs.get("detail");
        this.pendingReceipt = quoteRef9;
        normalize();
    }

    private void normalize() {
        String tariffRef10 = this.pendingReceipt;
        List<String> ledgerEntry11Attrs = new ArrayList<String>();
        ledgerEntry11Attrs.add("web");
        ledgerEntry11Attrs.add(tariffRef10);
        String ledgerEntry11 = ledgerEntry11Attrs.get(1);
        String channelTag12 = new StringBuilder(ledgerEntry11).toString();
        cachedReceipt = channelTag12;
        publish();
    }

    private void publish() {
        String catalogKey13 = cachedReceipt;
        Map<String, String> receiptKey14Attrs = new HashMap<String, String>();
        receiptKey14Attrs.put("channel", "web");
        receiptKey14Attrs.put("remark", catalogKey13);
        String receiptKey14 = receiptKey14Attrs.get("remark");
        List<String> accountRef15Attrs = new ArrayList<String>();
        accountRef15Attrs.add("web");
        accountRef15Attrs.add(receiptKey14);
        String accountRef15 = accountRef15Attrs.get(1);
        this.receiptCoordinator.assemble(accountRef15);
    }
}
