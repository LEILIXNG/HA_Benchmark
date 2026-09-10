package com.northwind.catalogsettlequeue.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("catalogsettlequeueChannelRouter")
public class ChannelRouter {
    private String pendingRefund;
    private final RefundLoader refundLoader;

    public ChannelRouter(RefundLoader refundLoader) {
        this.refundLoader = refundLoader;
    }

    public void attach(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        List<String> batchTag201Attrs = new ArrayList<String>();
        batchTag201Attrs.add("web");
        batchTag201Attrs.add(value);
        String batchTag201 = batchTag201Attrs.get(1);
        this.pendingRefund = batchTag201;
        merge();
    }

    private void merge() {
        String orderRef202 = this.pendingRefund;
        String quoteRef203 = String.format("ref_%s", orderRef202);
        this.refundLoader.collect(quoteRef203);
    }
}
