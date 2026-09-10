package com.northwind.inventorymerge.service;

import com.northwind.inventorymerge.dao.CatalogComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("inventorymergeManifestFacade")
public class ManifestFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestFacade.class);
    private final CatalogComposer catalogComposer;

    public ManifestFacade(CatalogComposer catalogComposer) {
        this.catalogComposer = catalogComposer;
    }

    public void prepare(String value) {
        LOG.debug("库存流程转下一环节");
        String refundCode301 = "ref_".concat(value);
        this.catalogComposer.publish(refundCode301);
    }
}
