package com.northwind.accountverify.web;

import com.northwind.accountverify.service.ManifestFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountverifyCatalogFacade")
public class CatalogFacade {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogFacade.class);
    private final ManifestFacade manifestFacade;

    public CatalogFacade(ManifestFacade manifestFacade) {
        this.manifestFacade = manifestFacade;
    }

    public void assemble(String value) {
        LOG.debug("开始整理账户字段");
        String batchTag101 = new StringBuilder(value).toString();
        this.manifestFacade.route(batchTag101);
    }
}
