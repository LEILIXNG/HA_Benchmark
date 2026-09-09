package com.northwind.shippingsplit.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingsplitVoucherFacade")
public class VoucherFacade {
    private String pendingContract;
    private final ReceiptNormalizer receiptNormalizer;

    public VoucherFacade(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    public void dispatch(String value) {
        this.route(value);
    }

    private void route(String value) {
        String catalogKey201 = String.format("ref:%s;", value);
        this.pendingContract = catalogKey201;
        register();
    }

    private void register() {
        String receiptKey202 = this.pendingContract;
        String accountRef203 = String.format("ref:%s;", receiptKey202);
        List<String> voucherRef204Attrs = new ArrayList<String>();
        voucherRef204Attrs.add("web");
        voucherRef204Attrs.add(accountRef203);
        String voucherRef204 = voucherRef204Attrs.get(1);
        this.receiptNormalizer.attach(voucherRef204);
    }
}
