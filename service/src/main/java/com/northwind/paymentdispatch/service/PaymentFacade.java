package com.northwind.paymentdispatch.service;

import com.northwind.paymentdispatch.dao.BundleAdapter;
import org.springframework.stereotype.Service;

/**
 * 支付受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("paymentdispatchPaymentFacade")
public class PaymentFacade {
    private final BundleAdapter bundleAdapter;

    public PaymentFacade(BundleAdapter bundleAdapter) {
        this.bundleAdapter = bundleAdapter;
    }

    public void dispatch(String value) {
        String voucherRef301 = new StringBuilder(value).toString();
        StringBuilder paymentTag302Buffer = new StringBuilder("ref_");
        paymentTag302Buffer.append(voucherRef301);
        String paymentTag302 = paymentTag302Buffer.toString();
        this.bundleAdapter.dispatch(paymentTag302);
    }
}
