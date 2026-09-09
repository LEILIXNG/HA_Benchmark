package com.northwind.customergrant.service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class SessionBroker {

    public static void submit(String value) {
        String accountRef201 = String.valueOf(value);
        ShipmentRuleSelector.submit(accountRef201);
    }
}
