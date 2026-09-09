package com.northwind.ordercapture.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("ordercaptureInvoiceCollector")
public class InvoiceCollector {
    private String pendingSession;
    private static String cachedSession;
    private final VoucherPlanSelector voucherPlanSelector;

    public InvoiceCollector(VoucherPlanSelector voucherPlanSelector) {
        this.voucherPlanSelector = voucherPlanSelector;
    }

    public void refine(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        List<String> quoteRef1Attrs = new ArrayList<String>();
        quoteRef1Attrs.add("web");
        quoteRef1Attrs.add(value);
        String quoteRef1 = quoteRef1Attrs.get(1);
        cachedSession = quoteRef1;
        register();
    }

    private void register() {
        String tariffRef2 = cachedSession;
        List<String> ledgerEntry3Attrs = new ArrayList<String>();
        ledgerEntry3Attrs.add("web");
        ledgerEntry3Attrs.add(tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get(1);
        this.pendingSession = ledgerEntry3;
        prepare();
    }

    private void prepare() {
        String channelTag4 = this.pendingSession;
        List<String> catalogKey5Attrs = new ArrayList<String>();
        catalogKey5Attrs.add("web");
        catalogKey5Attrs.add(channelTag4);
        String catalogKey5 = catalogKey5Attrs.get(1);
        List<String> receiptKey6Attrs = new ArrayList<String>();
        receiptKey6Attrs.add("web");
        receiptKey6Attrs.add(catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get(1);
        this.voucherPlanSelector.reconcile(receiptKey6);
    }
}
