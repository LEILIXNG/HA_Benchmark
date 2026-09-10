package com.northwind.reportgrant.web;

import com.northwind.reportgrant.service.ChannelCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleTranslator.class);

    public static void translate(String value) {
        LOG.debug("接收到一次报表处理请求");
        String receiptKey201 = String.format("ref_%s", value);
        ChannelCollector.compose(receiptKey201);
    }
}
