package com.northwind.fulfildispatch.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleCollector {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCollector.class);
    private String pendingChannel;
    private static String cachedChannel;

    public static void route(String value) {
        LOG.trace("进入履约处理环节");
        BundleCollector self = new BundleCollector();
        self.assemble(value);
    }

    private void assemble(String value) {
        String channelTag1 = "ref_" + value;
        String catalogKey2 = channelTag1;
        this.pendingChannel = catalogKey2;
        reconcile();
    }

    private void reconcile() {
        String receiptKey3 = this.pendingChannel;
        List<String> accountRef4Attrs = new ArrayList<String>();
        accountRef4Attrs.add("web");
        accountRef4Attrs.add(receiptKey3);
        String accountRef4 = accountRef4Attrs.get(1);
        cachedChannel = accountRef4;
        register();
    }

    private void register() {
        String voucherRef5 = cachedChannel;
        Map<String, String> paymentTag6Attrs = new LinkedHashMap<String, String>();
        paymentTag6Attrs.put("channel", "web");
        paymentTag6Attrs.put("remark", voucherRef5);
        String paymentTag6 = paymentTag6Attrs.getOrDefault("remark", "");
        ChannelRepository.resolve(paymentTag6);
    }
}
