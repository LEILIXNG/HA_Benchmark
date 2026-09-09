package com.northwind.shippingsubmit.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("shippingsubmitBundleBuilder")
public class BundleBuilder {
    private static String cachedBundle;

    public void resolve(String value) {
        final String quoteRef1 = value;
        cachedBundle = quoteRef1;
        stage();
    }

    private void stage() {
        String tariffRef2 = cachedBundle;
        List<String> ledgerEntry3Attrs = new ArrayList<String>();
        ledgerEntry3Attrs.add("web");
        ledgerEntry3Attrs.add(tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get(1);
        cachedBundle = ledgerEntry3;
        normalize();
    }

    private void normalize() {
        String channelTag4 = cachedBundle;
        String catalogKey5 = channelTag4;
        ChannelPolicySelector.route(catalogKey5);
    }
}
