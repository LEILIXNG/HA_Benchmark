package com.northwind.accountdraft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountdraftInvoiceFacade")
public class InvoiceFacade {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceFacade.class);
    private final ManifestResolver manifestResolver;

    public InvoiceFacade(ManifestResolver manifestResolver) {
        this.manifestResolver = manifestResolver;
    }

    public void forward(String value) {
        LOG.debug("账户流程转下一环节");
        String shipmentCode101 = String.format("ref_%s", value);
        this.manifestResolver.register(shipmentCode101);
    }
}
