package com.northwind.inventorysubmit.service;

import com.northwind.inventorysubmit.dao.ContractBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceBuilder {

    public static void assemble(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("detail", value);
        String tariffRef101 = tariffRef101Attrs.get("detail");
        ContractBuilder.dispatch(tariffRef101);
    }
}
