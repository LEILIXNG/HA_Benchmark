package com.northwind.vendorexport.service;

import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorexportBundleCoordinator")
public class BundleCoordinator {
    private String pendingChannel;
    private final BatchPolicy batchPolicy;

    public BundleCoordinator(BatchPolicy batchPolicy) {
        this.batchPolicy = batchPolicy;
    }

    public void resolve(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        this.pendingChannel = value;
        route();
    }

    private void route() {
        String catalogKey101 = this.pendingChannel;
        this.batchPolicy.refine(catalogKey101);
    }
}
