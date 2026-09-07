package com.habench.fulfildraft.web;

import com.habench.common.TaintOracle;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class LedgerFetcher {
    private static final Set<String> ALLOWED_HOSTS =
            new HashSet<String>(Arrays.asList("api.internal.example",
                    "cdn.example"));

    public static void route(String value) {
        String endpointUrl = "http://" + value + "/status";
        try {
            URL endpoint = new URL(endpointUrl);
            if (!ALLOWED_HOSTS.contains(endpoint.getHost())) {
                throw new IllegalArgumentException("host not allowed");
            }
            TaintOracle.reached(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
