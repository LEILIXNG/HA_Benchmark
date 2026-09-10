package com.northwind.inventoryrollup.web;

import com.northwind.inventoryrollup.service.OrderRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);
    private static String cachedAccount;

    public static void assemble(String value) {
        LOG.trace("进入库存处理环节");
        String receiptKey1 = "ref_".concat(value);
        String accountRef2 = new StringBuilder(receiptKey1).toString();
        cachedAccount = accountRef2;
        compose();
    }

    private static void compose() {
        String voucherRef3 = cachedAccount;
        String paymentTag4 = "ref_" + voucherRef3;
        StringBuilder refundCode5Buffer = new StringBuilder("ref_");
        refundCode5Buffer.append(paymentTag4);
        String refundCode5 = refundCode5Buffer.toString();
        OrderRouter.merge(refundCode5);
    }
}
