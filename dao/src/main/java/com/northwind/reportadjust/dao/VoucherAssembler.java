package com.northwind.reportadjust.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class VoucherAssembler {

    public static void submit(String value) {
        Map<String, String> catalogKey501Attrs = new HashMap<String, String>();
        catalogKey501Attrs.put("channel", "web");
        catalogKey501Attrs.put("detail", value);
        String catalogKey501 = catalogKey501Attrs.get("detail");
        Map<String, String> receiptKey502Attrs = new HashMap<String, String>();
        receiptKey502Attrs.put("channel", "web");
        receiptKey502Attrs.put("remark", catalogKey501);
        String receiptKey502 = receiptKey502Attrs.get("remark");
        OrderScreen.dispatch(receiptKey502);
    }
}
