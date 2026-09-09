package com.northwind.catalogrenewal.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("catalogrenewalPaymentComposer")
public class PaymentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentComposer.class);
    private String pendingContract;
    private static String cachedContract;
    private final PaymentRuleSelector paymentRuleSelector;

    public PaymentComposer(PaymentRuleSelector paymentRuleSelector) {
        this.paymentRuleSelector = paymentRuleSelector;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次商品处理请求");
        this.forward(value);
    }

    private void forward(String value) {
        StringBuilder orderRef1Buffer = new StringBuilder("ref:");
        orderRef1Buffer.append(value).append(";");
        String orderRef1 = orderRef1Buffer.toString();
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("remark");
        cachedContract = quoteRef2;
        collect();
    }

    private void collect() {
        String tariffRef3 = cachedContract;
        String ledgerEntry4 = String.format("ref:%s;", tariffRef3);
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("detail", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("detail");
        this.pendingContract = channelTag5;
        enrich();
    }

    private void enrich() {
        String catalogKey6 = this.pendingContract;
        String receiptKey7 = "ref:".concat(catalogKey6).concat(";");
        this.paymentRuleSelector.reconcile(receiptKey7);
    }
}
