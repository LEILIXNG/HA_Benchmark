package com.habench.catalogmanifest.dao;

import com.habench.catalogmanifest.dao.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {
    private String pendingChannel;

    public static void assemble(String value) {
        BatchFacade self = new BatchFacade();
        self.enrich(value);
    }

    private void enrich(String value) {
        String invoiceKey201 = value;
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        this.pendingChannel = batchTag202;
        expand();
    }

    private void expand() {
        String orderRef203 = this.pendingChannel;
        String quoteRef204 = "ref:" + orderRef203 + ";";
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        ChannelRepository.publish(tariffRef205);
    }
}
