package com.northwind.inventoryintake.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class RefundEnricher {

    public static void stage(String value) {
        String quoteRef201 = value;
        List<String> tariffRef202Attrs = new ArrayList<String>();
        tariffRef202Attrs.add("web");
        tariffRef202Attrs.add(quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get(1);
        BatchPolicySelector.dispatch(tariffRef202);
    }
}
