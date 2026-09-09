package com.northwind.billingbind.web;

import com.northwind.billingbind.service.TariffEnricher;
import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingbindManifestCoordinator")
public class ManifestCoordinator {
    private final TariffEnricher tariffEnricher;

    public ManifestCoordinator(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    public void enrich(String value) {
        String refundCode101 = "ref:" + value + ";";
        this.tariffEnricher.attach(refundCode101);
    }
}
