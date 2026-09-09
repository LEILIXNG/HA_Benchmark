package com.northwind.inventoryledger.service;

import com.northwind.inventoryledger.dao.ChannelBroker;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffAdapter {
    private String pendingOrder;

    public static void dispatch(String value) {
        TariffAdapter self = new TariffAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        List<String> batchTag201Attrs = new ArrayList<String>();
        batchTag201Attrs.add("web");
        batchTag201Attrs.add(value);
        String batchTag201 = batchTag201Attrs.get(1);
        this.pendingOrder = batchTag201;
        route();
    }

    private void route() {
        String orderRef202 = this.pendingOrder;
        Map<String, String> quoteRef203Attrs = new LinkedHashMap<String, String>();
        quoteRef203Attrs.put("channel", "web");
        quoteRef203Attrs.put("note", orderRef202);
        String quoteRef203 = quoteRef203Attrs.getOrDefault("note", "");
        String tariffRef204 = String.valueOf(quoteRef203);
        ChannelBroker.enrich(tariffRef204);
    }
}
