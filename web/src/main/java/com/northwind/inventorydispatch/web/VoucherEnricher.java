package com.northwind.inventorydispatch.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class VoucherEnricher {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        VoucherEnricher self = new VoucherEnricher();
        self.collect(value);
    }

    private void collect(String value) {
        String quoteRef201 = new StringBuilder(value).toString();
        String tariffRef202 = "ref:".concat(quoteRef201).concat(";");
        cachedReceipt = tariffRef202;
        resolve();
    }

    private void resolve() {
        String ledgerEntry203 = cachedReceipt;
        String channelTag204 = ledgerEntry203;
        String catalogKey205 = "ref:" + channelTag204 + ";";
        this.pendingReceipt = catalogKey205;
        register();
    }

    private void register() {
        String receiptKey206 = this.pendingReceipt;
        List<String> accountRef207Attrs = new ArrayList<String>();
        accountRef207Attrs.add("web");
        accountRef207Attrs.add(receiptKey206);
        String accountRef207 = accountRef207Attrs.get(1);
        String voucherRef208 = new StringBuilder(accountRef207).toString();
        TariffPlanSelector.register(voucherRef208);
    }
}
