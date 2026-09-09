package com.habench.accountsettlequeue.dao;

import com.habench.accountsettlequeue.dao.AccountStrategySelector;

public final class VoucherBroker {

    public static void dispatch(String value) {
        String accountRef301 = value;
        String voucherRef302 = "ref:" + accountRef301 + ";";
        AccountStrategySelector.enrich(voucherRef302);
    }
}
