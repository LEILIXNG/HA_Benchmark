package com.northwind.billinglookup.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("billinglookupContractComposer")
public class ContractComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractComposer.class);
    private String pendingContract;
    private static String cachedContract;
    private final OrderPolicy orderPolicy;

    public ContractComposer(OrderPolicy orderPolicy) {
        this.orderPolicy = orderPolicy;
    }

    public void submit(String value) {
        LOG.debug("接收到一次账务处理请求");
        this.merge(value);
    }

    private void merge(String value) {
        StringBuilder manifestKey101Buffer = new StringBuilder("ref:");
        manifestKey101Buffer.append(value).append(";");
        String manifestKey101 = manifestKey101Buffer.toString();
        this.pendingContract = manifestKey101;
        register();
    }

    private void register() {
        String invoiceKey102 = this.pendingContract;
        String batchTag103 = String.valueOf(invoiceKey102);
        cachedContract = batchTag103;
        collect();
    }

    private void collect() {
        String orderRef104 = cachedContract;
        String quoteRef105 = "ref:".concat(orderRef104).concat(";");
        this.pendingContract = quoteRef105;
        reconcile();
    }

    private void reconcile() {
        String tariffRef106 = this.pendingContract;
        String ledgerEntry107 = "ref:".concat(tariffRef106).concat(";");
        cachedContract = ledgerEntry107;
        normalize();
    }

    private void normalize() {
        String channelTag108 = cachedContract;
        Map<String, String> catalogKey109Attrs = new HashMap<String, String>();
        catalogKey109Attrs.put("channel", "web");
        catalogKey109Attrs.put("detail", channelTag108);
        String catalogKey109 = catalogKey109Attrs.get("detail");
        String receiptKey110 = String.format("ref:%s;", catalogKey109);
        this.pendingContract = receiptKey110;
        dispatch();
    }

    private void dispatch() {
        String accountRef111 = this.pendingContract;
        final String voucherRef112 = accountRef111;
        String paymentTag113 = new StringBuilder(voucherRef112).toString();
        this.orderPolicy.publish(paymentTag113);
    }
}
