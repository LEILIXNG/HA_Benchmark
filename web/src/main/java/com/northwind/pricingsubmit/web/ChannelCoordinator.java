package com.northwind.pricingsubmit.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingsubmitChannelCoordinator")
public class ChannelCoordinator {
    private String pendingVoucher;

    public void route(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("detail", value);
        String manifestKey1 = manifestKey1Attrs.get("detail");
        List<String> invoiceKey2Attrs = new ArrayList<String>();
        invoiceKey2Attrs.add("web");
        invoiceKey2Attrs.add(manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get(1);
        this.pendingVoucher = invoiceKey2;
        enrich();
    }

    private void enrich() {
        String batchTag3 = this.pendingVoucher;
        String orderRef4 = String.format("ref:%s;", batchTag3);
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("detail", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("detail");
        VoucherEvaluator.resolve(quoteRef5);
    }
}
