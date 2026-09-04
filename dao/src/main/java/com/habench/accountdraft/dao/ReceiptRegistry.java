package com.habench.accountdraft.dao;

import com.habench.accountdraft.dao.VoucherRuleSelector;

public final class ReceiptRegistry {

    public static void compose(String value) {
        String refundCode401 = value;
        VoucherRuleSelector.publish(refundCode401);
    }
}
