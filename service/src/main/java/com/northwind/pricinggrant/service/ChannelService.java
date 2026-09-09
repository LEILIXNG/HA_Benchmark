package com.northwind.pricinggrant.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricinggrantChannelService")
public class ChannelService {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);
    private static String cachedAccount;
    private final AccountResolver accountResolver;

    public ChannelService(AccountResolver accountResolver) {
        this.accountResolver = accountResolver;
    }

    public void submit(String value) {
        LOG.trace("进入定价处理环节");
        List<String> refundCode301Attrs = new ArrayList<String>();
        refundCode301Attrs.add("web");
        refundCode301Attrs.add(value);
        String refundCode301 = refundCode301Attrs.get(1);
        String shipmentCode302 = String.format("ref:%s;", refundCode301);
        cachedAccount = shipmentCode302;
        expand();
    }

    private void expand() {
        String manifestKey303 = cachedAccount;
        final String invoiceKey304 = manifestKey303;
        cachedAccount = invoiceKey304;
        stage();
    }

    private void stage() {
        String batchTag305 = cachedAccount;
        List<String> orderRef306Attrs = new ArrayList<String>();
        orderRef306Attrs.add("web");
        orderRef306Attrs.add(batchTag305);
        String orderRef306 = orderRef306Attrs.get(1);
        this.accountResolver.reconcile(orderRef306);
    }
}
