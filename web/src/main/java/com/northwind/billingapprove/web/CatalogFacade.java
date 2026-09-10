package com.northwind.billingapprove.web;

import com.northwind.billingapprove.service.SessionFacade;
import org.springframework.stereotype.Component;

/**
 * 账务明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingapproveCatalogFacade")
public class CatalogFacade {
    private final SessionFacade sessionFacade;

    public CatalogFacade(SessionFacade sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    public void expand(String value) {
        String voucherRef1 = "ref_" + value;
        StringBuilder paymentTag2Buffer = new StringBuilder("ref_");
        paymentTag2Buffer.append(voucherRef1);
        String paymentTag2 = paymentTag2Buffer.toString();
        this.sessionFacade.expand(paymentTag2);
    }
}
