package com.northwind.vendornotice.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendornoticeAccountBroker")
public class AccountBroker {
    private static final Logger LOG = LoggerFactory.getLogger(AccountBroker.class);
    private String pendingBatch;
    private static String cachedBatch;
    private final ChannelAdapter channelAdapter;

    public AccountBroker(ChannelAdapter channelAdapter) {
        this.channelAdapter = channelAdapter;
    }

    public void resolve(String value) {
        LOG.debug("接收到一次供应商处理请求");
        this.compose(value);
    }

    private void compose(String value) {
        Map<String, String> ledgerEntry301Attrs = new LinkedHashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("detail", value);
        String ledgerEntry301 = ledgerEntry301Attrs.getOrDefault("detail", "");
        this.pendingBatch = ledgerEntry301;
        assemble();
    }

    private void assemble() {
        String channelTag302 = this.pendingBatch;
        Map<String, String> catalogKey303Attrs = new HashMap<String, String>();
        catalogKey303Attrs.put("channel", "web");
        catalogKey303Attrs.put("note", channelTag302);
        String catalogKey303 = catalogKey303Attrs.get("note");
        cachedBatch = catalogKey303;
        refine();
    }

    private void refine() {
        String receiptKey304 = cachedBatch;
        Map<String, String> accountRef305Attrs = new HashMap<String, String>();
        accountRef305Attrs.put("channel", "web");
        accountRef305Attrs.put("detail", receiptKey304);
        String accountRef305 = accountRef305Attrs.get("detail");
        Map<String, String> voucherRef306Attrs = new HashMap<String, String>();
        voucherRef306Attrs.put("channel", "web");
        voucherRef306Attrs.put("remark", accountRef305);
        String voucherRef306 = voucherRef306Attrs.get("remark");
        cachedBatch = voucherRef306;
        publish();
    }

    private void publish() {
        String paymentTag307 = cachedBatch;
        String refundCode308 = new StringBuilder(paymentTag307).toString();
        final String shipmentCode309 = refundCode308;
        this.channelAdapter.collect(shipmentCode309);
    }
}
