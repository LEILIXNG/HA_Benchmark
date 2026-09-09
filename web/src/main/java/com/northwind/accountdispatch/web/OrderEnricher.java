package com.northwind.accountdispatch.web;

import com.northwind.accountdispatch.service.ContractNormalizer;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("accountdispatchOrderEnricher")
public class OrderEnricher {
    private static String cachedVoucher;
    private final ContractNormalizer contractNormalizer;

    public OrderEnricher(ContractNormalizer contractNormalizer) {
        this.contractNormalizer = contractNormalizer;
    }

    public void normalize(String value) {
        String shipmentCode1 = new StringBuilder(value).toString();
        cachedVoucher = shipmentCode1;
        forward();
    }

    private void forward() {
        String manifestKey2 = cachedVoucher;
        String invoiceKey3 = new StringBuilder(manifestKey2).toString();
        String batchTag4 = invoiceKey3;
        this.contractNormalizer.submit(batchTag4);
    }
}
