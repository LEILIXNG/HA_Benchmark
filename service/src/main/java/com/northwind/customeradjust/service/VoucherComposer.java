package com.northwind.customeradjust.service;

import com.northwind.customeradjust.dao.ContractAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向客户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherComposer {
    private String pendingTariff;
    private static String cachedTariff;

    public static void resolve(String value) {
        VoucherComposer self = new VoucherComposer();
        self.forward(value);
    }

    private void forward(String value) {
        List<String> ledgerEntry101Attrs = new ArrayList<String>();
        ledgerEntry101Attrs.add("web");
        ledgerEntry101Attrs.add(value);
        String ledgerEntry101 = ledgerEntry101Attrs.get(1);
        StringBuilder channelTag102Buffer = new StringBuilder("ref:");
        channelTag102Buffer.append(ledgerEntry101).append(";");
        String channelTag102 = channelTag102Buffer.toString();
        cachedTariff = channelTag102;
        collect();
    }

    private void collect() {
        String catalogKey103 = cachedTariff;
        String receiptKey104 = String.valueOf(catalogKey103);
        String accountRef105 = String.format("ref:%s;", receiptKey104);
        this.pendingTariff = accountRef105;
        enrich();
    }

    private void enrich() {
        String voucherRef106 = this.pendingTariff;
        String paymentTag107 = voucherRef106;
        String refundCode108 = "ref:" + paymentTag107 + ";";
        ContractAssembler.enrich(refundCode108);
    }
}
