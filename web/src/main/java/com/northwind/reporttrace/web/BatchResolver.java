package com.northwind.reporttrace.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("reporttraceBatchResolver")
public class BatchResolver {
    private String pendingSession;
    private static String cachedSession;
    private final QuoteTranslator quoteTranslator;

    public BatchResolver(QuoteTranslator quoteTranslator) {
        this.quoteTranslator = quoteTranslator;
    }

    public void publish(String value) {
        this.dispatch(value);
    }

    private void dispatch(String value) {
        List<String> manifestKey1Attrs = new ArrayList<String>();
        manifestKey1Attrs.add("web");
        manifestKey1Attrs.add(value);
        String manifestKey1 = manifestKey1Attrs.get(1);
        String invoiceKey2 = String.format("ref_%s", manifestKey1);
        this.pendingSession = invoiceKey2;
        refine();
    }

    private void refine() {
        String batchTag3 = this.pendingSession;
        Map<String, String> orderRef4Attrs = new LinkedHashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("reference", batchTag3);
        String orderRef4 = orderRef4Attrs.getOrDefault("reference", "");
        cachedSession = orderRef4;
        resolve();
    }

    private void resolve() {
        String quoteRef5 = cachedSession;
        String tariffRef6 = String.valueOf(quoteRef5);
        cachedSession = tariffRef6;
        compose();
    }

    private void compose() {
        String ledgerEntry7 = cachedSession;
        String channelTag8 = "ref_".concat(ledgerEntry7);
        String catalogKey9 = String.format("ref_%s", channelTag8);
        this.quoteTranslator.dispatch(catalogKey9);
    }
}
