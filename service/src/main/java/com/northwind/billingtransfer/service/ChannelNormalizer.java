package com.northwind.billingtransfer.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("billingtransferChannelNormalizer")
public class ChannelNormalizer {
    private String pendingCatalog;
    private static String cachedCatalog;
    private final CatalogGateway catalogGateway;

    public ChannelNormalizer(CatalogGateway catalogGateway) {
        this.catalogGateway = catalogGateway;
    }

    public void publish(String value) {
        this.register(value);
    }

    private void register(String value) {
        String shipmentCode101 = String.format("ref:%s;", value);
        this.pendingCatalog = shipmentCode101;
        dispatch();
    }

    private void dispatch() {
        String manifestKey102 = this.pendingCatalog;
        String invoiceKey103 = manifestKey102;
        cachedCatalog = invoiceKey103;
        enrich();
    }

    private void enrich() {
        String batchTag104 = cachedCatalog;
        String orderRef105 = "ref:" + batchTag104 + ";";
        this.pendingCatalog = orderRef105;
        attach();
    }

    private void attach() {
        String quoteRef106 = this.pendingCatalog;
        String tariffRef107 = "ref:" + quoteRef106 + ";";
        cachedCatalog = tariffRef107;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry108 = cachedCatalog;
        Map<String, String> channelTag109Attrs = new HashMap<String, String>();
        channelTag109Attrs.put("channel", "web");
        channelTag109Attrs.put("detail", ledgerEntry108);
        String channelTag109 = channelTag109Attrs.get("detail");
        StringBuilder catalogKey110Buffer = new StringBuilder("ref:");
        catalogKey110Buffer.append(channelTag109).append(";");
        String catalogKey110 = catalogKey110Buffer.toString();
        this.pendingCatalog = catalogKey110;
        stage();
    }

    private void stage() {
        String receiptKey111 = this.pendingCatalog;
        String accountRef112 = new StringBuilder(receiptKey111).toString();
        final String voucherRef113 = accountRef112;
        this.catalogGateway.enrich(voucherRef113);
    }
}
