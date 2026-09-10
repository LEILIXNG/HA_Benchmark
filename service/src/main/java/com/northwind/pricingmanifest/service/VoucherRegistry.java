package com.northwind.pricingmanifest.service;

import com.northwind.pricingmanifest.dao.VoucherRouter;
import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricingmanifestVoucherRegistry")
public class VoucherRegistry {
    private final VoucherRouter voucherRouter;

    public VoucherRegistry(VoucherRouter voucherRouter) {
        this.voucherRouter = voucherRouter;
    }

    public void assemble(String value) {
        StringBuilder orderRef301Buffer = new StringBuilder("ref_");
        orderRef301Buffer.append(value);
        String orderRef301 = orderRef301Buffer.toString();
        this.voucherRouter.compose(orderRef301);
    }
}
