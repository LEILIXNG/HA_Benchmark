package com.habench.customerrollup.dao;

import com.habench.customerrollup.dao.ChannelLoader;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {
    private String pendingChannel;

    public static void normalize(String value) {
        ManifestAdapter self = new ManifestAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> orderRef501Attrs = new HashMap<String, String>();
        orderRef501Attrs.put("channel", "web");
        orderRef501Attrs.put("payload", value);
        String orderRef501 = orderRef501Attrs.get("payload");
        this.pendingChannel = orderRef501;
        compose();
    }

    private void compose() {
        String quoteRef502 = this.pendingChannel;
        Map<String, String> tariffRef503Attrs = new HashMap<String, String>();
        tariffRef503Attrs.put("channel", "web");
        tariffRef503Attrs.put("payload", quoteRef502);
        String tariffRef503 = tariffRef503Attrs.get("payload");
        ChannelLoader.translate(tariffRef503);
    }
}
