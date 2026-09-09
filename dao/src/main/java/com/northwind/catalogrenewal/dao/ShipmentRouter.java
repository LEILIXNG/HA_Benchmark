package com.northwind.catalogrenewal.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentRouter {

    public static void attach(String value) {
        List<String> catalogKey501Attrs = new ArrayList<String>();
        catalogKey501Attrs.add("web");
        catalogKey501Attrs.add(value);
        String catalogKey501 = catalogKey501Attrs.get(1);
        final String receiptKey502 = catalogKey501;
        ContractRepository.stage(receiptKey502);
    }
}
