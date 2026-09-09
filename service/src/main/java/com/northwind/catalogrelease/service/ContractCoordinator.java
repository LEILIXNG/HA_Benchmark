package com.northwind.catalogrelease.service;

import com.northwind.catalogrelease.dao.BatchEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogreleaseContractCoordinator")
public class ContractCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCoordinator.class);
    private final BatchEnricher batchEnricher;

    public ContractCoordinator(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    public void translate(String value) {
        LOG.debug("商品流程转下一环节");
        final String manifestKey101 = value;
        this.batchEnricher.stage(manifestKey101);
    }
}
