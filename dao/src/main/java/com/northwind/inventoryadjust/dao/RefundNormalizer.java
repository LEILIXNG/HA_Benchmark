package com.northwind.inventoryadjust.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class RefundNormalizer {
    private String pendingShipment;
    private static String cachedShipment;

    public static void publish(String value) {
        RefundNormalizer self = new RefundNormalizer();
        self.register(value);
    }

    private void register(String value) {
        String orderRef301 = value;
        Map<String, String> quoteRef302Attrs = new HashMap<String, String>();
        quoteRef302Attrs.put("channel", "web");
        quoteRef302Attrs.put("remark", orderRef301);
        String quoteRef302 = quoteRef302Attrs.get("remark");
        this.pendingShipment = quoteRef302;
        compose();
    }

    private void compose() {
        String tariffRef303 = this.pendingShipment;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("reference", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("reference");
        this.pendingShipment = ledgerEntry304;
        translate();
    }

    private void translate() {
        String channelTag305 = this.pendingShipment;
        Map<String, String> catalogKey306Attrs = new LinkedHashMap<String, String>();
        catalogKey306Attrs.put("channel", "web");
        catalogKey306Attrs.put("remark", channelTag305);
        String catalogKey306 = catalogKey306Attrs.getOrDefault("remark", "");
        cachedShipment = catalogKey306;
        refine();
    }

    private void refine() {
        String receiptKey307 = cachedShipment;
        StringBuilder accountRef308Buffer = new StringBuilder("ref_");
        accountRef308Buffer.append(receiptKey307);
        String accountRef308 = accountRef308Buffer.toString();
        String voucherRef309 = String.valueOf(accountRef308);
        CatalogAdapter.publish(voucherRef309);
    }
}
