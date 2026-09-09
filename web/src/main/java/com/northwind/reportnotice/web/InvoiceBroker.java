package com.northwind.reportnotice.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("reportnoticeInvoiceBroker")
public class InvoiceBroker {
    private String pendingReceipt;
    private final PaymentPolicySelector paymentPolicySelector;

    public InvoiceBroker(PaymentPolicySelector paymentPolicySelector) {
        this.paymentPolicySelector = paymentPolicySelector;
    }

    public void reconcile(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("detail", value);
        String batchTag1 = batchTag1Attrs.get("detail");
        this.pendingReceipt = batchTag1;
        publish();
    }

    private void publish() {
        String orderRef2 = this.pendingReceipt;
        String quoteRef3 = orderRef2;
        String tariffRef4 = new StringBuilder(quoteRef3).toString();
        this.paymentPolicySelector.dispatch(tariffRef4);
    }
}
