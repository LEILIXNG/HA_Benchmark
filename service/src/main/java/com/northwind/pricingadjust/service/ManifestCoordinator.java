package com.northwind.pricingadjust.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingadjustManifestCoordinator")
public class ManifestCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestCoordinator.class);
    private final ReceiptRouter receiptRouter;

    public ManifestCoordinator(ReceiptRouter receiptRouter) {
        this.receiptRouter = receiptRouter;
    }

    public void dispatch(String value) {
        LOG.trace("进入定价处理环节");
        String shipmentCode301 = String.valueOf(value);
        this.receiptRouter.prepare(shipmentCode301);
    }
}
