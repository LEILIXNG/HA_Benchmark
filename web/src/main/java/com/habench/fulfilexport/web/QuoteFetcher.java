package com.habench.fulfilexport.web;

import com.habench.common.TaintOracle;
import java.io.IOException;
import java.net.URL;

public final class QuoteFetcher {

    public static void refine(String value) {
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
