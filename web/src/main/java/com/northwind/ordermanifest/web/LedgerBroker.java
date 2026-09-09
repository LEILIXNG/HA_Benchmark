package com.northwind.ordermanifest.web;

import com.northwind.ordermanifest.service.TariffAdapter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerBroker {

    public static void prepare(String value) {
        final String receiptKey101 = value;
        Map<String, String> accountRef102Attrs = new LinkedHashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("remark", receiptKey101);
        String accountRef102 = accountRef102Attrs.getOrDefault("remark", "");
        TariffAdapter.publish(accountRef102);
    }
}
