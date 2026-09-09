package com.northwind.vendorsettle.web;

import com.northwind.vendorsettle.service.TariffBroker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("vendorsettleTariffNormalizer")
public class TariffNormalizer {
    private String pendingLedger;
    private static String cachedLedger;
    private final TariffBroker tariffBroker;

    public TariffNormalizer(TariffBroker tariffBroker) {
        this.tariffBroker = tariffBroker;
    }

    public void collect(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String receiptKey1 = String.format("ref:%s;", value);
        List<String> accountRef2Attrs = new ArrayList<String>();
        accountRef2Attrs.add("web");
        accountRef2Attrs.add(receiptKey1);
        String accountRef2 = accountRef2Attrs.get(1);
        this.pendingLedger = accountRef2;
        assemble();
    }

    private void assemble() {
        String voucherRef3 = this.pendingLedger;
        List<String> paymentTag4Attrs = new ArrayList<String>();
        paymentTag4Attrs.add("web");
        paymentTag4Attrs.add(voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get(1);
        this.pendingLedger = paymentTag4;
        normalize();
    }

    private void normalize() {
        String refundCode5 = this.pendingLedger;
        StringBuilder shipmentCode6Buffer = new StringBuilder("ref:");
        shipmentCode6Buffer.append(refundCode5).append(";");
        String shipmentCode6 = shipmentCode6Buffer.toString();
        this.pendingLedger = shipmentCode6;
        publish();
    }

    private void publish() {
        String manifestKey7 = this.pendingLedger;
        String invoiceKey8 = manifestKey7;
        String batchTag9 = String.valueOf(invoiceKey8);
        cachedLedger = batchTag9;
        enrich();
    }

    private void enrich() {
        String orderRef10 = cachedLedger;
        String quoteRef11 = new StringBuilder(orderRef10).toString();
        String tariffRef12 = String.format("ref:%s;", quoteRef11);
        this.pendingLedger = tariffRef12;
        resolve();
    }

    private void resolve() {
        String ledgerEntry13 = this.pendingLedger;
        Map<String, String> channelTag14Attrs = new HashMap<String, String>();
        channelTag14Attrs.put("channel", "web");
        channelTag14Attrs.put("remark", ledgerEntry13);
        String channelTag14 = channelTag14Attrs.get("remark");
        this.pendingLedger = channelTag14;
        expand();
    }

    private void expand() {
        String catalogKey15 = this.pendingLedger;
        String receiptKey16 = catalogKey15;
        this.tariffBroker.merge(receiptKey16);
    }
}
