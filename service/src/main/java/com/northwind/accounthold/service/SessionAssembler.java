package com.northwind.accounthold.service;

import com.northwind.accounthold.dao.OrderComposer;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 账户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class SessionAssembler {
    private String pendingSession;

    public static void publish(String value) {
        SessionAssembler self = new SessionAssembler();
        self.normalize(value);
    }

    private void normalize(String value) {
        String refundCode101 = new StringBuilder(value).toString();
        this.pendingSession = refundCode101;
        attach();
    }

    private void attach() {
        String shipmentCode102 = this.pendingSession;
        String manifestKey103 = "ref_".concat(shipmentCode102);
        Map<String, String> invoiceKey104Attrs = new LinkedHashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("reference", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.getOrDefault("reference", "");
        OrderComposer.prepare(invoiceKey104);
    }
}
