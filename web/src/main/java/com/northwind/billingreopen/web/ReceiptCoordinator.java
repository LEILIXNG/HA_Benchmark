package com.northwind.billingreopen.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("billingreopenReceiptCoordinator")
public class ReceiptCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCoordinator.class);
    private final BundleCollector bundleCollector;

    public ReceiptCoordinator(BundleCollector bundleCollector) {
        this.bundleCollector = bundleCollector;
    }

    public void assemble(String value) {
        LOG.trace("进入账务处理环节");
        List<String> orderRef1Attrs = new ArrayList<String>();
        orderRef1Attrs.add("web");
        orderRef1Attrs.add(value);
        String orderRef1 = orderRef1Attrs.get(1);
        List<String> quoteRef2Attrs = new ArrayList<String>();
        quoteRef2Attrs.add("web");
        quoteRef2Attrs.add(orderRef1);
        String quoteRef2 = quoteRef2Attrs.get(1);
        this.bundleCollector.enrich(quoteRef2);
    }
}
