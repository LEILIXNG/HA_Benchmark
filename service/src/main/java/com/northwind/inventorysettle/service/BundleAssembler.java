package com.northwind.inventorysettle.service;

import com.northwind.inventorysettle.dao.ContractBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("inventorysettleBundleAssembler")
public class BundleAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAssembler.class);
    private String pendingRefund;
    private final ContractBroker contractBroker;

    public BundleAssembler(ContractBroker contractBroker) {
        this.contractBroker = contractBroker;
    }

    public void prepare(String value) {
        LOG.debug("库存流程转下一环节");
        this.stage(value);
    }

    private void stage(String value) {
        String accountRef201 = new StringBuilder(value).toString();
        this.pendingRefund = accountRef201;
        collect();
    }

    private void collect() {
        String voucherRef202 = this.pendingRefund;
        String paymentTag203 = new StringBuilder(voucherRef202).toString();
        String refundCode204 = "ref:" + paymentTag203 + ";";
        this.pendingRefund = refundCode204;
        route();
    }

    private void route() {
        String shipmentCode205 = this.pendingRefund;
        String manifestKey206 = shipmentCode205;
        this.contractBroker.refine(manifestKey206);
    }
}
