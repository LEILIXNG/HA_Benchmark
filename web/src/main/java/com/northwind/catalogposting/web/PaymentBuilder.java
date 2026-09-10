package com.northwind.catalogposting.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("catalogpostingPaymentBuilder")
public class PaymentBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentBuilder.class);
    private String pendingAccount;
    private static String cachedAccount;
    private final ReceiptStrategySelector receiptStrategySelector;

    public PaymentBuilder(ReceiptStrategySelector receiptStrategySelector) {
        this.receiptStrategySelector = receiptStrategySelector;
    }

    public void dispatch(String value) {
        LOG.debug("接收到一次商品处理请求");
        this.collect(value);
    }

    private void collect(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.get("detail");
        this.pendingAccount = shipmentCode1;
        stage();
    }

    private void stage() {
        String manifestKey2 = this.pendingAccount;
        StringBuilder invoiceKey3Buffer = new StringBuilder("ref_");
        invoiceKey3Buffer.append(manifestKey2);
        String invoiceKey3 = invoiceKey3Buffer.toString();
        this.pendingAccount = invoiceKey3;
        route();
    }

    private void route() {
        String batchTag4 = this.pendingAccount;
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("detail", batchTag4);
        String orderRef5 = orderRef5Attrs.get("detail");
        cachedAccount = orderRef5;
        expand();
    }

    private void expand() {
        String quoteRef6 = cachedAccount;
        String tariffRef7 = quoteRef6;
        StringBuilder ledgerEntry8Buffer = new StringBuilder("ref_");
        ledgerEntry8Buffer.append(tariffRef7);
        String ledgerEntry8 = ledgerEntry8Buffer.toString();
        this.receiptStrategySelector.register(ledgerEntry8);
    }
}
