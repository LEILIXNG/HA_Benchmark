package com.northwind.catalogrefund.web;

import com.northwind.catalogrefund.service.PaymentComposer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogrefundLedgerCoordinator")
public class LedgerCoordinator {
    private final PaymentComposer paymentComposer;

    public LedgerCoordinator(PaymentComposer paymentComposer) {
        this.paymentComposer = paymentComposer;
    }

    public void route(String value) {
        String ledgerEntry101 = String.format("ref:%s;", value);
        Map<String, String> channelTag102Attrs = new LinkedHashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("remark", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.getOrDefault("remark", "");
        this.paymentComposer.refine(channelTag102);
    }
}
