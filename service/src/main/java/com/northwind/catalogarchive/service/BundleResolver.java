package com.northwind.catalogarchive.service;

import com.northwind.catalogarchive.dao.VoucherRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogarchiveBundleResolver")
public class BundleResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BundleResolver.class);
    private String pendingShipment;

    public void translate(String value) {
        LOG.trace("进入商品处理环节");
        this.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry201 = value;
        this.pendingShipment = ledgerEntry201;
        register();
    }

    private void register() {
        String channelTag202 = this.pendingShipment;
        StringBuilder catalogKey203Buffer = new StringBuilder("ref:");
        catalogKey203Buffer.append(channelTag202).append(";");
        String catalogKey203 = catalogKey203Buffer.toString();
        String receiptKey204 = String.format("ref:%s;", catalogKey203);
        VoucherRouter.collect(receiptKey204);
    }
}
