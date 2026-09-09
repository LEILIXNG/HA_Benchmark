package com.northwind.orderarchive.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("orderarchiveVoucherCollector")
public class VoucherCollector {
    private String pendingOrder;
    private static String cachedOrder;
    private final QuoteRouter quoteRouter;

    public VoucherCollector(QuoteRouter quoteRouter) {
        this.quoteRouter = quoteRouter;
    }

    public void attach(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> ledgerEntry301Attrs = new LinkedHashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("detail", value);
        String ledgerEntry301 = ledgerEntry301Attrs.getOrDefault("detail", "");
        this.pendingOrder = ledgerEntry301;
        merge();
    }

    private void merge() {
        String channelTag302 = this.pendingOrder;
        List<String> catalogKey303Attrs = new ArrayList<String>();
        catalogKey303Attrs.add("web");
        catalogKey303Attrs.add(channelTag302);
        String catalogKey303 = catalogKey303Attrs.get(1);
        cachedOrder = catalogKey303;
        collect();
    }

    private void collect() {
        String receiptKey304 = cachedOrder;
        Map<String, String> accountRef305Attrs = new HashMap<String, String>();
        accountRef305Attrs.put("channel", "web");
        accountRef305Attrs.put("detail", receiptKey304);
        String accountRef305 = accountRef305Attrs.get("detail");
        List<String> voucherRef306Attrs = new ArrayList<String>();
        voucherRef306Attrs.add("web");
        voucherRef306Attrs.add(accountRef305);
        String voucherRef306 = voucherRef306Attrs.get(1);
        cachedOrder = voucherRef306;
        register();
    }

    private void register() {
        String paymentTag307 = cachedOrder;
        String refundCode308 = new StringBuilder(paymentTag307).toString();
        final String shipmentCode309 = refundCode308;
        this.quoteRouter.normalize(shipmentCode309);
    }
}
