package com.northwind.inventorydraft.web;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventorydraftChannelPolicyStandard")
public class ChannelPolicyStandard implements ChannelPolicy {
    private final VoucherRouter voucherRouter;

    public ChannelPolicyStandard(VoucherRouter voucherRouter) {
        this.voucherRouter = voucherRouter;
    }

    @Override
    public void handle(String value) {
        this.voucherRouter.stage(value);
    }
}
