package com.northwind.inventorydispatch.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelRegistry {

    public static void refine(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("detail", value);
        String receiptKey401 = receiptKey401Attrs.get("detail");
        List<String> accountRef402Attrs = new ArrayList<String>();
        accountRef402Attrs.add("web");
        accountRef402Attrs.add(receiptKey401);
        String accountRef402 = accountRef402Attrs.get(1);
        ReceiptExecutor.route(accountRef402);
    }
}
