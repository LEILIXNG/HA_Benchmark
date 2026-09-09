package com.northwind.catalogdigest.service;

import com.northwind.catalogdigest.dao.ContractEnricher;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderService {

    public static void publish(String value) {
        String orderRef301 = value;
        ContractEnricher.prepare(orderRef301);
    }
}
