package com.habench.billinglookup.dao;

import com.habench.billinglookup.dao.VoucherPolicySelector;

public final class QuoteService {
    private String pendingAccount;

    public static void dispatch(String value) {
        QuoteService self = new QuoteService();
        self.stage(value);
    }

    private void stage(String value) {
        String orderRef301 = value;
        String quoteRef302 = orderRef301;
        this.pendingAccount = quoteRef302;
        translate();
    }

    private void translate() {
        String tariffRef303 = this.pendingAccount;
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        String channelTag305 = "ref:" + ledgerEntry304 + ";";
        VoucherPolicySelector.normalize(channelTag305);
    }
}
