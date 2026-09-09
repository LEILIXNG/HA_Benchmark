package com.northwind.vendorledger.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("vendorledgerRefundAssembler")
public class RefundAssembler {
    private String pendingChannel;
    private static String cachedChannel;
    private final ChannelGateway channelGateway;

    public RefundAssembler(ChannelGateway channelGateway) {
        this.channelGateway = channelGateway;
    }

    public void reconcile(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        String receiptKey301 = value;
        String accountRef302 = "ref:".concat(receiptKey301).concat(";");
        this.pendingChannel = accountRef302;
        forward();
    }

    private void forward() {
        String voucherRef303 = this.pendingChannel;
        List<String> paymentTag304Attrs = new ArrayList<String>();
        paymentTag304Attrs.add("web");
        paymentTag304Attrs.add(voucherRef303);
        String paymentTag304 = paymentTag304Attrs.get(1);
        cachedChannel = paymentTag304;
        refine();
    }

    private void refine() {
        String refundCode305 = cachedChannel;
        StringBuilder shipmentCode306Buffer = new StringBuilder("ref:");
        shipmentCode306Buffer.append(refundCode305).append(";");
        String shipmentCode306 = shipmentCode306Buffer.toString();
        Map<String, String> manifestKey307Attrs = new LinkedHashMap<String, String>();
        manifestKey307Attrs.put("channel", "web");
        manifestKey307Attrs.put("note", shipmentCode306);
        String manifestKey307 = manifestKey307Attrs.getOrDefault("note", "");
        this.channelGateway.merge(manifestKey307);
    }
}
