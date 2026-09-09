package com.northwind.customerlookup.web;

import com.northwind.customerlookup.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("customerlookupLedgerResolver")
public class LedgerResolver {
    private String pendingAccount;
    private static String cachedAccount;

    public void attach(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        final String shipmentCode1 = value;
        cachedAccount = shipmentCode1;
        prepare();
    }

    private void prepare() {
        String manifestKey2 = cachedAccount;
        StringBuilder invoiceKey3Buffer = new StringBuilder("ref:");
        invoiceKey3Buffer.append(manifestKey2).append(";");
        String invoiceKey3 = invoiceKey3Buffer.toString();
        Map<String, String> batchTag4Attrs = new HashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("reference", invoiceKey3);
        String batchTag4 = batchTag4Attrs.get("reference");
        this.pendingAccount = batchTag4;
        submit();
    }

    private void submit() {
        String orderRef5 = this.pendingAccount;
        Map<String, String> quoteRef6Attrs = new HashMap<String, String>();
        quoteRef6Attrs.put("channel", "web");
        quoteRef6Attrs.put("remark", orderRef5);
        String quoteRef6 = quoteRef6Attrs.get("remark");
        this.pendingAccount = quoteRef6;
        publish();
    }

    private void publish() {
        String tariffRef7 = this.pendingAccount;
        StringBuilder ledgerEntry8Buffer = new StringBuilder("ref:");
        ledgerEntry8Buffer.append(tariffRef7).append(";");
        String ledgerEntry8 = ledgerEntry8Buffer.toString();
        ShipmentRouter.refine(ledgerEntry8);
    }
}
