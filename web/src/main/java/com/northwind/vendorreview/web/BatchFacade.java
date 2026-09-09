package com.northwind.vendorreview.web;

import com.northwind.vendorreview.service.OrderFacade;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorreviewBatchFacade")
public class BatchFacade {
    private String pendingCatalog;
    private static String cachedCatalog;
    private final OrderFacade orderFacade;

    public BatchFacade(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    public void compose(String value) {
        this.route(value);
    }

    private void route(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("detail", value);
        String invoiceKey101 = invoiceKey101Attrs.get("detail");
        Map<String, String> batchTag102Attrs = new LinkedHashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("remark", invoiceKey101);
        String batchTag102 = batchTag102Attrs.getOrDefault("remark", "");
        this.pendingCatalog = batchTag102;
        refine();
    }

    private void refine() {
        String orderRef103 = this.pendingCatalog;
        Map<String, String> quoteRef104Attrs = new LinkedHashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("reference", orderRef103);
        String quoteRef104 = quoteRef104Attrs.getOrDefault("reference", "");
        final String tariffRef105 = quoteRef104;
        this.pendingCatalog = tariffRef105;
        assemble();
    }

    private void assemble() {
        String ledgerEntry106 = this.pendingCatalog;
        StringBuilder channelTag107Buffer = new StringBuilder("ref:");
        channelTag107Buffer.append(ledgerEntry106).append(";");
        String channelTag107 = channelTag107Buffer.toString();
        cachedCatalog = channelTag107;
        enrich();
    }

    private void enrich() {
        String catalogKey108 = cachedCatalog;
        String receiptKey109 = String.format("ref:%s;", catalogKey108);
        this.orderFacade.route(receiptKey109);
    }
}
