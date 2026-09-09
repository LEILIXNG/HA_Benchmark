package com.northwind.billingverify.web;

import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingverifyVoucherCoordinator")
public class VoucherCoordinator {

    public void prepare(String value) {
        String voucherRef1 = String.format("ref:%s;", value);
        BundleBuilder.translate(voucherRef1);
    }
}
