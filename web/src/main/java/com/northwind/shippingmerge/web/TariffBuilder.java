package com.northwind.shippingmerge.web;

import com.northwind.shippingmerge.service.ReceiptComposer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 发运受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("shippingmergeTariffBuilder")
public class TariffBuilder {
    private static String cachedAccount;
    private final ReceiptComposer receiptComposer;

    public TariffBuilder(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    public void translate(String value) {
        List<String> channelTag1Attrs = new ArrayList<String>();
        channelTag1Attrs.add("web");
        channelTag1Attrs.add(value);
        String channelTag1 = channelTag1Attrs.get(1);
        List<String> catalogKey2Attrs = new ArrayList<String>();
        catalogKey2Attrs.add("web");
        catalogKey2Attrs.add(channelTag1);
        String catalogKey2 = catalogKey2Attrs.get(1);
        cachedAccount = catalogKey2;
        merge();
    }

    private void merge() {
        String receiptKey3 = cachedAccount;
        List<String> accountRef4Attrs = new ArrayList<String>();
        accountRef4Attrs.add("web");
        accountRef4Attrs.add(receiptKey3);
        String accountRef4 = accountRef4Attrs.get(1);
        String voucherRef5 = new StringBuilder(accountRef4).toString();
        this.receiptComposer.register(voucherRef5);
    }
}
