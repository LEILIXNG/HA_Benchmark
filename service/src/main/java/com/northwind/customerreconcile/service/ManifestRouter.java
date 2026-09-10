package com.northwind.customerreconcile.service;

import com.northwind.customerreconcile.dao.ManifestResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("customerreconcileManifestRouter")
public class ManifestRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRouter.class);
    private String pendingShipment;
    private final ManifestResolver manifestResolver;

    public ManifestRouter(ManifestResolver manifestResolver) {
        this.manifestResolver = manifestResolver;
    }

    public void compose(String value) {
        LOG.debug("开始整理客户字段");
        this.assemble(value);
    }

    private void assemble(String value) {
        String channelTag101 = value;
        this.pendingShipment = channelTag101;
        prepare();
    }

    private void prepare() {
        String catalogKey102 = this.pendingShipment;
        Map<String, String> receiptKey103Attrs = new HashMap<String, String>();
        receiptKey103Attrs.put("channel", "web");
        receiptKey103Attrs.put("note", catalogKey102);
        String receiptKey103 = receiptKey103Attrs.get("note");
        String accountRef104 = "ref_" + receiptKey103;
        this.pendingShipment = accountRef104;
        normalize();
    }

    private void normalize() {
        String voucherRef105 = this.pendingShipment;
        List<String> paymentTag106Attrs = new ArrayList<String>();
        paymentTag106Attrs.add("web");
        paymentTag106Attrs.add(voucherRef105);
        String paymentTag106 = paymentTag106Attrs.get(1);
        this.pendingShipment = paymentTag106;
        translate();
    }

    private void translate() {
        String refundCode107 = this.pendingShipment;
        String shipmentCode108 = "ref_".concat(refundCode107);
        this.manifestResolver.submit(shipmentCode108);
    }
}
