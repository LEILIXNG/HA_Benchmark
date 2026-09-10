package com.northwind.paymentbind.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class SessionResolver {
    private static String cachedSession;

    public static void refine(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("detail", value);
        String quoteRef201 = quoteRef201Attrs.get("detail");
        cachedSession = quoteRef201;
        compose();
    }

    private static void compose() {
        String tariffRef202 = cachedSession;
        String ledgerEntry203 = String.format("ref_%s", tariffRef202);
        StringBuilder channelTag204Buffer = new StringBuilder("ref_");
        channelTag204Buffer.append(ledgerEntry203);
        String channelTag204 = channelTag204Buffer.toString();
        VoucherBroker.submit(channelTag204);
    }
}
