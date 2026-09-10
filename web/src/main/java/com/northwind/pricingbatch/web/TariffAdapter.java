package com.northwind.pricingbatch.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingbatchTariffAdapter")
public class TariffAdapter {
    private final PaymentPolicySelector paymentPolicySelector;

    public TariffAdapter(PaymentPolicySelector paymentPolicySelector) {
        this.paymentPolicySelector = paymentPolicySelector;
    }

    public void attach(String value) {
        StringBuilder tariffRef1Buffer = new StringBuilder("ref_");
        tariffRef1Buffer.append(value);
        String tariffRef1 = tariffRef1Buffer.toString();
        List<String> ledgerEntry2Attrs = new ArrayList<String>();
        ledgerEntry2Attrs.add("web");
        ledgerEntry2Attrs.add(tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get(1);
        this.paymentPolicySelector.prepare(ledgerEntry2);
    }
}
