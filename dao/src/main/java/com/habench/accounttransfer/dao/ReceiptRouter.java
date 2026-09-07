package com.habench.accounttransfer.dao;

import com.habench.accounttransfer.dao.SessionRuleSelector;

public final class ReceiptRouter {

    public static void refine(String value) {
        String orderRef301 = "ref:" + value + ";";
        SessionRuleSelector.route(orderRef301);
    }
}
