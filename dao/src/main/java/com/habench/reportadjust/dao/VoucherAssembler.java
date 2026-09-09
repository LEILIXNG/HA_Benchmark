package com.habench.reportadjust.dao;

import com.habench.reportadjust.dao.OrderScreen;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {

    public static void submit(String value) {
        Map<String, String> catalogKey501Attrs = new HashMap<String, String>();
        catalogKey501Attrs.put("channel", "web");
        catalogKey501Attrs.put("payload", value);
        String catalogKey501 = catalogKey501Attrs.get("payload");
        Map<String, String> receiptKey502Attrs = new HashMap<String, String>();
        receiptKey502Attrs.put("channel", "web");
        receiptKey502Attrs.put("payload", catalogKey501);
        String receiptKey502 = receiptKey502Attrs.get("payload");
        OrderScreen.dispatch(receiptKey502);
    }
}
