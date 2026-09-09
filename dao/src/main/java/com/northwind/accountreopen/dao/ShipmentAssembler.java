package com.northwind.accountreopen.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentAssembler.class);

    public static void assemble(String value) {
        LOG.debug("开始整理账户字段");
        Map<String, String> ledgerEntry201Attrs = new LinkedHashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("detail", value);
        String ledgerEntry201 = ledgerEntry201Attrs.getOrDefault("detail", "");
        String channelTag202 = ledgerEntry201;
        BundleAdapter.merge(channelTag202);
    }
}
