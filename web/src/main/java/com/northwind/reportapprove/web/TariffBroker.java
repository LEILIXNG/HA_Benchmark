package com.northwind.reportapprove.web;

import com.northwind.reportapprove.service.SessionBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportapproveTariffBroker")
public class TariffBroker {
    private String pendingQuote;
    private static String cachedQuote;
    private final SessionBuilder sessionBuilder;

    public TariffBroker(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public void stage(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        List<String> channelTag101Attrs = new ArrayList<String>();
        channelTag101Attrs.add("web");
        channelTag101Attrs.add(value);
        String channelTag101 = channelTag101Attrs.get(1);
        this.pendingQuote = channelTag101;
        refine();
    }

    private void refine() {
        String catalogKey102 = this.pendingQuote;
        StringBuilder receiptKey103Buffer = new StringBuilder("ref_");
        receiptKey103Buffer.append(catalogKey102);
        String receiptKey103 = receiptKey103Buffer.toString();
        final String accountRef104 = receiptKey103;
        cachedQuote = accountRef104;
        publish();
    }

    private void publish() {
        String voucherRef105 = cachedQuote;
        String paymentTag106 = String.format("ref_%s", voucherRef105);
        String refundCode107 = "ref_".concat(paymentTag106);
        this.sessionBuilder.translate(refundCode107);
    }
}
