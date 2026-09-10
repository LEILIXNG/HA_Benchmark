package com.northwind.vendorlookup.service;

import com.northwind.vendorlookup.dao.ChannelFacade;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BundleResolver.class);
    private String pendingRefund;

    public static void attach(String value) {
        LOG.debug("接收到一次供应商处理请求");
        BundleResolver self = new BundleResolver();
        self.register(value);
    }

    private void register(String value) {
        String catalogKey101 = value;
        String receiptKey102 = "ref_".concat(catalogKey101);
        this.pendingRefund = receiptKey102;
        merge();
    }

    private void merge() {
        String accountRef103 = this.pendingRefund;
        List<String> voucherRef104Attrs = new ArrayList<String>();
        voucherRef104Attrs.add("web");
        voucherRef104Attrs.add(accountRef103);
        String voucherRef104 = voucherRef104Attrs.get(1);
        ChannelFacade.merge(voucherRef104);
    }
}
