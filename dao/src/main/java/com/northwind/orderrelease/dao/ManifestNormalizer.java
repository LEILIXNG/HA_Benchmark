package com.northwind.orderrelease.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("orderreleaseManifestNormalizer")
public class ManifestNormalizer {
    private final TariffRuleSelector tariffRuleSelector;

    public ManifestNormalizer(TariffRuleSelector tariffRuleSelector) {
        this.tariffRuleSelector = tariffRuleSelector;
    }

    public void enrich(String value) {
        List<String> channelTag301Attrs = new ArrayList<String>();
        channelTag301Attrs.add("web");
        channelTag301Attrs.add(value);
        String channelTag301 = channelTag301Attrs.get(1);
        String catalogKey302 = String.valueOf(channelTag301);
        this.tariffRuleSelector.publish(catalogKey302);
    }
}
