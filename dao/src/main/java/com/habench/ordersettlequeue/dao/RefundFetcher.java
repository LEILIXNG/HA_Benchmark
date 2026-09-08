package com.habench.ordersettlequeue.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;
import java.net.URL;

public final class RefundFetcher {

    public static void compose(String value) {
        String endpointUrl = "http://" + value + "/status";
        TaintOracle.reached(endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
