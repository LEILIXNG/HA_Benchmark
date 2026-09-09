package com.northwind.inventoryadjust.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelCollector {

    public static void resolve(String value) {
        List<String> catalogKey201Attrs = new ArrayList<String>();
        catalogKey201Attrs.add("web");
        catalogKey201Attrs.add(value);
        String catalogKey201 = catalogKey201Attrs.get(1);
        RefundNormalizer.publish(catalogKey201);
    }
}
