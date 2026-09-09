package com.northwind.pricingintake.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 定价明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class TariffFacade {

    public static void route(String value) {
        List<String> orderRef301Attrs = new ArrayList<String>();
        orderRef301Attrs.add("web");
        orderRef301Attrs.add(value);
        String orderRef301 = orderRef301Attrs.get(1);
        ContractFilter.stage(orderRef301);
    }
}
