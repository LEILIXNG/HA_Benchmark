package com.northwind.reportreconcile.service;

import com.northwind.reportreconcile.dao.RefundCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("reportreconcileQuoteComposer")
public class QuoteComposer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteComposer.class);
    private final RefundCoordinator refundCoordinator;

    public QuoteComposer(RefundCoordinator refundCoordinator) {
        this.refundCoordinator = refundCoordinator;
    }

    public void translate(String value) {
        LOG.debug("接收到一次报表处理请求");
        final String accountRef301 = value;
        this.refundCoordinator.normalize(accountRef301);
    }
}
