package com.northwind.reportreopen.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportreopenChannelCoordinator")
public class ChannelCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCoordinator.class);
    private String pendingBatch;
    private static String cachedBatch;
    private final PaymentAdapter paymentAdapter;

    public ChannelCoordinator(PaymentAdapter paymentAdapter) {
        this.paymentAdapter = paymentAdapter;
    }

    public void prepare(String value) {
        LOG.trace("进入报表处理环节");
        this.forward(value);
    }

    private void forward(String value) {
        String invoiceKey1 = new StringBuilder(value).toString();
        cachedBatch = invoiceKey1;
        normalize();
    }

    private void normalize() {
        String batchTag2 = cachedBatch;
        String orderRef3 = new StringBuilder(batchTag2).toString();
        this.pendingBatch = orderRef3;
        refine();
    }

    private void refine() {
        String quoteRef4 = this.pendingBatch;
        Map<String, String> tariffRef5Attrs = new HashMap<String, String>();
        tariffRef5Attrs.put("channel", "web");
        tariffRef5Attrs.put("detail", quoteRef4);
        String tariffRef5 = tariffRef5Attrs.get("detail");
        this.paymentAdapter.compose(tariffRef5);
    }
}
