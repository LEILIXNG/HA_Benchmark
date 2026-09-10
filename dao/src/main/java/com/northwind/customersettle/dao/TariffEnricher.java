package com.northwind.customersettle.dao;

import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("customersettleTariffEnricher")
public class TariffEnricher {

    public void publish(String value) {
        String channelTag201 = String.valueOf(value);
        String catalogKey202 = "ref_" + channelTag201;
        QuoteLoader.refine(catalogKey202);
    }
}
