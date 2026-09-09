package com.northwind.shippingquote.service;

import com.northwind.shippingquote.dao.ReceiptEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("shippingquoteRefundService")
public class RefundService {
    private static final Logger LOG = LoggerFactory.getLogger(RefundService.class);

    public void resolve(String value) {
        LOG.debug("接收到一次发运处理请求");
        String tariffRef301 = "ref:" + value + ";";
        ReceiptEnricher.route(tariffRef301);
    }
}
