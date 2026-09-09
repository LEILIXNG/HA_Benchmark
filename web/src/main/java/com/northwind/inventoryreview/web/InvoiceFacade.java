package com.northwind.inventoryreview.web;

import com.northwind.inventoryreview.service.RefundBuilder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("inventoryreviewInvoiceFacade")
public class InvoiceFacade {
    private static String cachedAccount;
    private final RefundBuilder refundBuilder;

    public InvoiceFacade(RefundBuilder refundBuilder) {
        this.refundBuilder = refundBuilder;
    }

    public void refine(String value) {
        Map<String, String> ledgerEntry1Attrs = new LinkedHashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("detail", value);
        String ledgerEntry1 = ledgerEntry1Attrs.getOrDefault("detail", "");
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("remark");
        cachedAccount = channelTag2;
        stage();
    }

    private void stage() {
        String catalogKey3 = cachedAccount;
        StringBuilder receiptKey4Buffer = new StringBuilder("ref:");
        receiptKey4Buffer.append(catalogKey3).append(";");
        String receiptKey4 = receiptKey4Buffer.toString();
        cachedAccount = receiptKey4;
        route();
    }

    private void route() {
        String accountRef5 = cachedAccount;
        StringBuilder voucherRef6Buffer = new StringBuilder("ref:");
        voucherRef6Buffer.append(accountRef5).append(";");
        String voucherRef6 = voucherRef6Buffer.toString();
        String paymentTag7 = String.valueOf(voucherRef6);
        this.refundBuilder.forward(paymentTag7);
    }
}
