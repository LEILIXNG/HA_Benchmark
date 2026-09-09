package com.northwind.orderlookup.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderlookupRefundFacade")
public class RefundFacade {
    private static final Logger LOG = LoggerFactory.getLogger(RefundFacade.class);
    private String pendingReceipt;
    private static String cachedReceipt;
    private final PaymentRuleSelector paymentRuleSelector;

    public RefundFacade(PaymentRuleSelector paymentRuleSelector) {
        this.paymentRuleSelector = paymentRuleSelector;
    }

    public void translate(String value) {
        LOG.debug("开始整理订单字段");
        this.route(value);
    }

    private void route(String value) {
        String paymentTag201 = new StringBuilder(value).toString();
        StringBuilder refundCode202Buffer = new StringBuilder("ref:");
        refundCode202Buffer.append(paymentTag201).append(";");
        String refundCode202 = refundCode202Buffer.toString();
        cachedReceipt = refundCode202;
        assemble();
    }

    private void assemble() {
        String shipmentCode203 = cachedReceipt;
        String manifestKey204 = shipmentCode203;
        String invoiceKey205 = String.format("ref:%s;", manifestKey204);
        this.pendingReceipt = invoiceKey205;
        dispatch();
    }

    private void dispatch() {
        String batchTag206 = this.pendingReceipt;
        List<String> orderRef207Attrs = new ArrayList<String>();
        orderRef207Attrs.add("web");
        orderRef207Attrs.add(batchTag206);
        String orderRef207 = orderRef207Attrs.get(1);
        String quoteRef208 = new StringBuilder(orderRef207).toString();
        this.paymentRuleSelector.publish(quoteRef208);
    }
}
