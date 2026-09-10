package com.northwind.shippingimport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class RefundBroker {
    private String pendingCatalog;

    public static void route(String value) {
        RefundBroker self = new RefundBroker();
        self.publish(value);
    }

    private void publish(String value) {
        String channelTag101 = value;
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("remark", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("remark");
        this.pendingCatalog = catalogKey102;
        assemble();
    }

    private void assemble() {
        String receiptKey103 = this.pendingCatalog;
        StringBuilder accountRef104Buffer = new StringBuilder("ref_");
        accountRef104Buffer.append(receiptKey103);
        String accountRef104 = accountRef104Buffer.toString();
        List<String> voucherRef105Attrs = new ArrayList<String>();
        voucherRef105Attrs.add("web");
        voucherRef105Attrs.add(accountRef104);
        String voucherRef105 = voucherRef105Attrs.get(1);
        VoucherGuard.stage(voucherRef105);
    }
}
