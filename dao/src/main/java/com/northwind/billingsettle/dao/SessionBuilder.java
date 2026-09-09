package com.northwind.billingsettle.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("billingsettleSessionBuilder")
public class SessionBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SessionBuilder.class);
    private String pendingLedger;
    private static String cachedLedger;
    private final LedgerRepository ledgerRepository;

    public SessionBuilder(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public void reconcile(String value) {
        LOG.debug("接收到一次账务处理请求");
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("detail", value);
        String paymentTag201 = paymentTag201Attrs.get("detail");
        String refundCode202 = new StringBuilder(paymentTag201).toString();
        cachedLedger = refundCode202;
        refine();
    }

    private void refine() {
        String shipmentCode203 = cachedLedger;
        String manifestKey204 = String.valueOf(shipmentCode203);
        String invoiceKey205 = manifestKey204;
        this.pendingLedger = invoiceKey205;
        assemble();
    }

    private void assemble() {
        String batchTag206 = this.pendingLedger;
        String orderRef207 = batchTag206;
        cachedLedger = orderRef207;
        expand();
    }

    private void expand() {
        String quoteRef208 = cachedLedger;
        String tariffRef209 = String.format("ref:%s;", quoteRef208);
        String ledgerEntry210 = String.valueOf(tariffRef209);
        this.pendingLedger = ledgerEntry210;
        collect();
    }

    private void collect() {
        String channelTag211 = this.pendingLedger;
        String catalogKey212 = "ref:" + channelTag211 + ";";
        this.ledgerRepository.prepare(catalogKey212);
    }
}
