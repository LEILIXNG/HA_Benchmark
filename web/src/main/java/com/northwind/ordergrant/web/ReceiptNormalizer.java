package com.northwind.ordergrant.web;

import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("ordergrantReceiptNormalizer")
public class ReceiptNormalizer {
    private static String cachedCatalog;
    private final AccountService accountService;

    public ReceiptNormalizer(AccountService accountService) {
        this.accountService = accountService;
    }

    public void compose(String value) {
        String voucherRef1 = "ref:".concat(value).concat(";");
        cachedCatalog = voucherRef1;
        translate();
    }

    private void translate() {
        String paymentTag2 = cachedCatalog;
        String refundCode3 = "ref:".concat(paymentTag2).concat(";");
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        this.accountService.submit(shipmentCode4);
    }
}
