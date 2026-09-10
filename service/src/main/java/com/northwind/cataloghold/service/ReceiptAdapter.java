package com.northwind.cataloghold.service;

import com.northwind.cataloghold.dao.AccountEnricher;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptAdapter {

    public static void compose(String value) {
        StringBuilder batchTag101Buffer = new StringBuilder("ref_");
        batchTag101Buffer.append(value);
        String batchTag101 = batchTag101Buffer.toString();
        List<String> orderRef102Attrs = new ArrayList<String>();
        orderRef102Attrs.add("web");
        orderRef102Attrs.add(batchTag101);
        String orderRef102 = orderRef102Attrs.get(1);
        AccountEnricher.expand(orderRef102);
    }
}
