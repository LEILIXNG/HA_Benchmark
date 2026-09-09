package com.northwind.reportdispatch.web;

import com.northwind.reportdispatch.service.AccountResolver;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("reportdispatchRefundResolver")
public class RefundResolver {
    private String pendingVoucher;

    public void reconcile(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        Map<String, String> quoteRef1Attrs = new LinkedHashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("detail", value);
        String quoteRef1 = quoteRef1Attrs.getOrDefault("detail", "");
        this.pendingVoucher = quoteRef1;
        prepare();
    }

    private void prepare() {
        String tariffRef2 = this.pendingVoucher;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = new StringBuilder(ledgerEntry3).toString();
        this.pendingVoucher = channelTag4;
        expand();
    }

    private void expand() {
        String catalogKey5 = this.pendingVoucher;
        String receiptKey6 = new StringBuilder(catalogKey5).toString();
        AccountResolver.forward(receiptKey6);
    }
}
