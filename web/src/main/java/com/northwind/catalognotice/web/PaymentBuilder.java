package com.northwind.catalognotice.web;

import com.northwind.catalognotice.service.AccountAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("catalognoticePaymentBuilder")
public class PaymentBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentBuilder.class);
    private String pendingOrder;
    private final AccountAdapter accountAdapter;

    public PaymentBuilder(AccountAdapter accountAdapter) {
        this.accountAdapter = accountAdapter;
    }

    public void assemble(String value) {
        LOG.debug("开始整理商品字段");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String paymentTag1 = new StringBuilder(value).toString();
        List<String> refundCode2Attrs = new ArrayList<String>();
        refundCode2Attrs.add("web");
        refundCode2Attrs.add(paymentTag1);
        String refundCode2 = refundCode2Attrs.get(1);
        this.pendingOrder = refundCode2;
        merge();
    }

    private void merge() {
        String shipmentCode3 = this.pendingOrder;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("reference", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("reference");
        StringBuilder invoiceKey5Buffer = new StringBuilder("ref:");
        invoiceKey5Buffer.append(manifestKey4).append(";");
        String invoiceKey5 = invoiceKey5Buffer.toString();
        this.accountAdapter.normalize(invoiceKey5);
    }
}
