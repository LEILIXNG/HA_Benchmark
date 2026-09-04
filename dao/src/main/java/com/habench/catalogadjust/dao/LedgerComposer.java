package com.habench.catalogadjust.dao;

import com.habench.catalogadjust.dao.QuoteRepository;
import java.util.HashMap;
import java.util.Map;

public final class LedgerComposer {
    private String pendingQuote;
    private static String cachedQuote;

    public static void collect(String value) {
        LedgerComposer self = new LedgerComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String manifestKey301 = "ref:" + value + ";";
        String invoiceKey302 = "ref:" + manifestKey301 + ";";
        cachedQuote = invoiceKey302;
        stage();
    }

    private void stage() {
        String batchTag303 = cachedQuote;
        String orderRef304 = "ref:" + batchTag303 + ";";
        Map<String, String> quoteRef305Attrs = new HashMap<String, String>();
        quoteRef305Attrs.put("channel", "web");
        quoteRef305Attrs.put("payload", orderRef304);
        String quoteRef305 = quoteRef305Attrs.get("payload");
        this.pendingQuote = quoteRef305;
        resolve();
    }

    private void resolve() {
        String tariffRef306 = this.pendingQuote;
        String ledgerEntry307 = "ref:" + tariffRef306 + ";";
        String channelTag308 = "ref:" + ledgerEntry307 + ";";
        cachedQuote = channelTag308;
        assemble();
    }

    private void assemble() {
        String catalogKey309 = cachedQuote;
        String receiptKey310 = catalogKey309;
        String accountRef311 = receiptKey310;
        this.pendingQuote = accountRef311;
        normalize();
    }

    private void normalize() {
        String voucherRef312 = this.pendingQuote;
        String paymentTag313 = "ref:" + voucherRef312 + ";";
        String refundCode314 = paymentTag313;
        this.pendingQuote = refundCode314;
        prepare();
    }

    private void prepare() {
        String shipmentCode315 = this.pendingQuote;
        String manifestKey316 = shipmentCode315;
        this.pendingQuote = manifestKey316;
        publish();
    }

    private void publish() {
        String invoiceKey317 = this.pendingQuote;
        String batchTag318 = "ref:" + invoiceKey317 + ";";
        String orderRef319 = batchTag318;
        QuoteRepository.reconcile(orderRef319);
    }
}
