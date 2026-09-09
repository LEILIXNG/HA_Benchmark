package com.northwind.inventoryverify.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("inventoryverifyRefundBroker")
public class RefundBroker {
    private static final Logger LOG = LoggerFactory.getLogger(RefundBroker.class);
    private String pendingManifest;
    private final RefundComposer refundComposer;

    public RefundBroker(RefundComposer refundComposer) {
        this.refundComposer = refundComposer;
    }

    public void register(String value) {
        LOG.debug("库存流程转下一环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        List<String> catalogKey201Attrs = new ArrayList<String>();
        catalogKey201Attrs.add("web");
        catalogKey201Attrs.add(value);
        String catalogKey201 = catalogKey201Attrs.get(1);
        List<String> receiptKey202Attrs = new ArrayList<String>();
        receiptKey202Attrs.add("web");
        receiptKey202Attrs.add(catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get(1);
        this.pendingManifest = receiptKey202;
        enrich();
    }

    private void enrich() {
        String accountRef203 = this.pendingManifest;
        String voucherRef204 = new StringBuilder(accountRef203).toString();
        this.refundComposer.submit(voucherRef204);
    }
}
