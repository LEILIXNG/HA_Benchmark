package com.northwind.accountsubmit.web;

import com.northwind.accountsubmit.service.ContractComposer;
import org.springframework.stereotype.Component;

/**
 * 账户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountsubmitManifestEnricher")
public class ManifestEnricher {
    private String pendingSession;
    private final ContractComposer contractComposer;

    public ManifestEnricher(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    public void translate(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        String paymentTag1 = "ref:".concat(value).concat(";");
        this.pendingSession = paymentTag1;
        forward();
    }

    private void forward() {
        String refundCode2 = this.pendingSession;
        String shipmentCode3 = "ref:".concat(refundCode2).concat(";");
        this.contractComposer.stage(shipmentCode3);
    }
}
