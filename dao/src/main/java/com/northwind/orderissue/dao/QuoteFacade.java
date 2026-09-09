package com.northwind.orderissue.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class QuoteFacade {

    public static void assemble(String value) {
        Map<String, String> channelTag401Attrs = new HashMap<String, String>();
        channelTag401Attrs.put("channel", "web");
        channelTag401Attrs.put("detail", value);
        String channelTag401 = channelTag401Attrs.get("detail");
        TariffGuard.compose(channelTag401);
    }
}
