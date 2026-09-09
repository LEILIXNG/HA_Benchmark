package com.northwind.vendorassign.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorassignBundleRegistry")
public class BundleRegistry {
    private static String cachedManifest;

    public void forward(String value) {
        Map<String, String> orderRef101Attrs = new LinkedHashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("detail", value);
        String orderRef101 = orderRef101Attrs.getOrDefault("detail", "");
        cachedManifest = orderRef101;
        submit();
    }

    private void submit() {
        String quoteRef102 = cachedManifest;
        String tariffRef103 = String.format("ref:%s;", quoteRef102);
        Map<String, String> ledgerEntry104Attrs = new LinkedHashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("reference", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.getOrDefault("reference", "");
        cachedManifest = ledgerEntry104;
        dispatch();
    }

    private void dispatch() {
        String channelTag105 = cachedManifest;
        Map<String, String> catalogKey106Attrs = new HashMap<String, String>();
        catalogKey106Attrs.put("channel", "web");
        catalogKey106Attrs.put("remark", channelTag105);
        String catalogKey106 = catalogKey106Attrs.get("remark");
        cachedManifest = catalogKey106;
        translate();
    }

    private void translate() {
        String receiptKey107 = cachedManifest;
        Map<String, String> accountRef108Attrs = new HashMap<String, String>();
        accountRef108Attrs.put("channel", "web");
        accountRef108Attrs.put("reference", receiptKey107);
        String accountRef108 = accountRef108Attrs.get("reference");
        String voucherRef109 = String.valueOf(accountRef108);
        BundleFacade.merge(voucherRef109);
    }
}
