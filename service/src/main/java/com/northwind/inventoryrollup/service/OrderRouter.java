package com.northwind.inventoryrollup.service;

import com.northwind.inventoryrollup.dao.QuoteAssembler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderRouter {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRouter.class);
    private String pendingAccount;
    private static String cachedAccount;

    public static void merge(String value) {
        LOG.trace("进入库存处理环节");
        OrderRouter self = new OrderRouter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String quoteRef101 = String.valueOf(value);
        String tariffRef102 = quoteRef101;
        this.pendingAccount = tariffRef102;
        enrich();
    }

    private void enrich() {
        String ledgerEntry103 = this.pendingAccount;
        Map<String, String> channelTag104Attrs = new LinkedHashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("reference", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.getOrDefault("reference", "");
        cachedAccount = channelTag104;
        compose();
    }

    private void compose() {
        String catalogKey105 = cachedAccount;
        final String receiptKey106 = catalogKey105;
        String accountRef107 = new StringBuilder(receiptKey106).toString();
        cachedAccount = accountRef107;
        translate();
    }

    private void translate() {
        String voucherRef108 = cachedAccount;
        List<String> paymentTag109Attrs = new ArrayList<String>();
        paymentTag109Attrs.add("web");
        paymentTag109Attrs.add(voucherRef108);
        String paymentTag109 = paymentTag109Attrs.get(1);
        String refundCode110 = "ref:" + paymentTag109 + ";";
        this.pendingAccount = refundCode110;
        publish();
    }

    private void publish() {
        String shipmentCode111 = this.pendingAccount;
        String manifestKey112 = "ref:" + shipmentCode111 + ";";
        String invoiceKey113 = new StringBuilder(manifestKey112).toString();
        this.pendingAccount = invoiceKey113;
        dispatch();
    }

    private void dispatch() {
        String batchTag114 = this.pendingAccount;
        Map<String, String> orderRef115Attrs = new LinkedHashMap<String, String>();
        orderRef115Attrs.put("channel", "web");
        orderRef115Attrs.put("note", batchTag114);
        String orderRef115 = orderRef115Attrs.getOrDefault("note", "");
        QuoteAssembler.route(orderRef115);
    }
}
