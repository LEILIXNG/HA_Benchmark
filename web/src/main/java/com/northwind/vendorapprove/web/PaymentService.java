package com.northwind.vendorapprove.web;

import com.northwind.vendorapprove.service.TariffNormalizer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorapprovePaymentService")
public class PaymentService {
    private final TariffNormalizer tariffNormalizer;

    public PaymentService(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    public void resolve(String value) {
        final String tariffRef1 = value;
        List<String> ledgerEntry2Attrs = new ArrayList<String>();
        ledgerEntry2Attrs.add("web");
        ledgerEntry2Attrs.add(tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get(1);
        this.tariffNormalizer.merge(ledgerEntry2);
    }
}
