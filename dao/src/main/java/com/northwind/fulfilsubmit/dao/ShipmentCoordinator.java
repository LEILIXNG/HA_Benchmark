package com.northwind.fulfilsubmit.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("fulfilsubmitShipmentCoordinator")
public class ShipmentCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentCoordinator.class);
    private String pendingReceipt;
    private static String cachedReceipt;
    private final ReceiptEvaluator receiptEvaluator;

    public ShipmentCoordinator(ReceiptEvaluator receiptEvaluator) {
        this.receiptEvaluator = receiptEvaluator;
    }

    public void stage(String value) {
        LOG.debug("履约流程转下一环节");
        this.publish(value);
    }

    private void publish(String value) {
        String ledgerEntry201 = String.valueOf(value);
        List<String> channelTag202Attrs = new ArrayList<String>();
        channelTag202Attrs.add("web");
        channelTag202Attrs.add(ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get(1);
        cachedReceipt = channelTag202;
        dispatch();
    }

    private void dispatch() {
        String catalogKey203 = cachedReceipt;
        final String receiptKey204 = catalogKey203;
        String accountRef205 = String.format("ref:%s;", receiptKey204);
        this.pendingReceipt = accountRef205;
        normalize();
    }

    private void normalize() {
        String voucherRef206 = this.pendingReceipt;
        String paymentTag207 = String.format("ref:%s;", voucherRef206);
        String refundCode208 = String.valueOf(paymentTag207);
        this.receiptEvaluator.dispatch(refundCode208);
    }
}
