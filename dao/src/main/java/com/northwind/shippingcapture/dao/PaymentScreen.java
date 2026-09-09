package com.northwind.shippingcapture.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentScreen {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentScreen.class);

    public static void collect(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value;
        if (cleaned.indexOf("../") >= 0) {
            cleaned = cleaned.replace("../", "");
        }
        ChannelLoader.resolve(cleaned);
    }
}
