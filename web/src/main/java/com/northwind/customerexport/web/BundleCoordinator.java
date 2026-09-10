package com.northwind.customerexport.web;

import org.springframework.stereotype.Component;

/**
 * 客户处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customerexportBundleCoordinator")
public class BundleCoordinator {

    public void reconcile(String value) {
        String catalogKey1 = String.valueOf(value);
        String receiptKey2 = catalogKey1;
        LedgerScreen.route(receiptKey2);
    }
}
