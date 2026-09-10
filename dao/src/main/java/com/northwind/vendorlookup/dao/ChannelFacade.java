package com.northwind.vendorlookup.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelFacade.class);

    public static void merge(String value) {
        LOG.debug("接收到一次供应商处理请求");
        String orderRef201 = "ref_" + value;
        BatchPolicy.submit(orderRef201);
    }
}
