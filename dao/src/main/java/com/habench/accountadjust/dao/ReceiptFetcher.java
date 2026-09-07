package com.habench.accountadjust.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;
import java.net.URL;

public final class ReceiptFetcher {

    public static void enrich(String value) {
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
