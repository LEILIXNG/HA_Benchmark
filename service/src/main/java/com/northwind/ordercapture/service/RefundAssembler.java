package com.northwind.ordercapture.service;

import com.northwind.ordercapture.dao.RefundEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("ordercaptureRefundAssembler")
public class RefundAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(RefundAssembler.class);
    private final RefundEnricher refundEnricher;

    public RefundAssembler(RefundEnricher refundEnricher) {
        this.refundEnricher = refundEnricher;
    }

    public void normalize(String value) {
        LOG.debug("接收到一次订单处理请求");
        String quoteRef301 = String.format("ref:%s;", value);
        this.refundEnricher.resolve(quoteRef301);
    }
}
