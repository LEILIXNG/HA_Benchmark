package com.northwind.vendordigest.web;

import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("vendordigestSessionRegistry")
public class SessionRegistry {
    private String pendingTariff;
    private final ManifestPolicySelector manifestPolicySelector;

    public SessionRegistry(ManifestPolicySelector manifestPolicySelector) {
        this.manifestPolicySelector = manifestPolicySelector;
    }

    public void translate(String value) {
        this.publish(value);
    }

    private void publish(String value) {
        String tariffRef1 = value;
        String ledgerEntry2 = "ref_".concat(tariffRef1);
        this.pendingTariff = ledgerEntry2;
        stage();
    }

    private void stage() {
        String channelTag3 = this.pendingTariff;
        StringBuilder catalogKey4Buffer = new StringBuilder("ref_");
        catalogKey4Buffer.append(channelTag3);
        String catalogKey4 = catalogKey4Buffer.toString();
        this.manifestPolicySelector.register(catalogKey4);
    }
}
