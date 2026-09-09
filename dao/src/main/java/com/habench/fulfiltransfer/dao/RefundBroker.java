package com.habench.fulfiltransfer.dao;

import com.habench.fulfiltransfer.dao.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingBundle;

    public static void enrich(String value) {
        RefundBroker self = new RefundBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        String quoteRef601 = value;
        Map<String, String> tariffRef602Attrs = new HashMap<String, String>();
        tariffRef602Attrs.put("channel", "web");
        tariffRef602Attrs.put("payload", quoteRef601);
        String tariffRef602 = tariffRef602Attrs.get("payload");
        this.pendingBundle = tariffRef602;
        compose();
    }

    private void compose() {
        String ledgerEntry603 = this.pendingBundle;
        String channelTag604 = "ref:" + ledgerEntry603 + ";";
        BundleLoader.route(channelTag604);
    }
}
