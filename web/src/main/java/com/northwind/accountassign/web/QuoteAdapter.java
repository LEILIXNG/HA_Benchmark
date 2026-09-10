package com.northwind.accountassign.web;

import com.northwind.accountassign.service.SessionCoordinator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("accountassignQuoteAdapter")
public class QuoteAdapter {
    private String pendingManifest;
    private static String cachedManifest;
    private final SessionCoordinator sessionCoordinator;

    public QuoteAdapter(SessionCoordinator sessionCoordinator) {
        this.sessionCoordinator = sessionCoordinator;
    }

    public void compose(String value) {
        this.register(value);
    }

    private void register(String value) {
        final String catalogKey1 = value;
        this.pendingManifest = catalogKey1;
        collect();
    }

    private void collect() {
        String receiptKey2 = this.pendingManifest;
        final String accountRef3 = receiptKey2;
        String voucherRef4 = String.format("ref_%s", accountRef3);
        cachedManifest = voucherRef4;
        reconcile();
    }

    private void reconcile() {
        String paymentTag5 = cachedManifest;
        Map<String, String> refundCode6Attrs = new LinkedHashMap<String, String>();
        refundCode6Attrs.put("channel", "web");
        refundCode6Attrs.put("remark", paymentTag5);
        String refundCode6 = refundCode6Attrs.getOrDefault("remark", "");
        cachedManifest = refundCode6;
        refine();
    }

    private void refine() {
        String shipmentCode7 = cachedManifest;
        List<String> manifestKey8Attrs = new ArrayList<String>();
        manifestKey8Attrs.add("web");
        manifestKey8Attrs.add(shipmentCode7);
        String manifestKey8 = manifestKey8Attrs.get(1);
        this.sessionCoordinator.submit(manifestKey8);
    }
}
