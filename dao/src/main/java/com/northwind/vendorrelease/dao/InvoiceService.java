package com.northwind.vendorrelease.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("vendorreleaseInvoiceService")
public class InvoiceService {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);
    private String pendingLedger;

    public void stage(String value) {
        LOG.debug("开始整理供应商字段");
        this.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey401 = "ref:" + value + ";";
        this.pendingLedger = manifestKey401;
        forward();
    }

    private void forward() {
        String invoiceKey402 = this.pendingLedger;
        Map<String, String> batchTag403Attrs = new HashMap<String, String>();
        batchTag403Attrs.put("channel", "web");
        batchTag403Attrs.put("note", invoiceKey402);
        String batchTag403 = batchTag403Attrs.get("note");
        LedgerGateway.translate(batchTag403);
    }
}
