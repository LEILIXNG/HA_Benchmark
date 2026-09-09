package com.northwind.fulfilreopen.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestCoordinator.class);
    private String pendingRefund;

    public static void merge(String value) {
        LOG.debug("履约流程转下一环节");
        ManifestCoordinator self = new ManifestCoordinator();
        self.assemble(value);
    }

    private void assemble(String value) {
        String batchTag1 = new StringBuilder(value).toString();
        this.pendingRefund = batchTag1;
        refine();
    }

    private void refine() {
        String orderRef2 = this.pendingRefund;
        List<String> quoteRef3Attrs = new ArrayList<String>();
        quoteRef3Attrs.add("web");
        quoteRef3Attrs.add(orderRef2);
        String quoteRef3 = quoteRef3Attrs.get(1);
        VoucherPolicySelector.merge(quoteRef3);
    }
}
