package com.habench.paymentsettlequeue.dao;

import com.habench.paymentsettlequeue.dao.ContractStrategySelector;

public final class RefundBroker {
    private String pendingSession;

    public static void publish(String value) {
        RefundBroker self = new RefundBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        String tariffRef201 = value;
        this.pendingSession = tariffRef201;
        forward();
    }

    private void forward() {
        String ledgerEntry202 = this.pendingSession;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        ContractStrategySelector.attach(channelTag203);
    }
}
