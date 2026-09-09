package com.northwind.reportposting.service;

import com.northwind.reportposting.dao.RefundCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("reportpostingVoucherRouter")
public class VoucherRouter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRouter.class);
    private final RefundCoordinator refundCoordinator;

    public VoucherRouter(RefundCoordinator refundCoordinator) {
        this.refundCoordinator = refundCoordinator;
    }

    public void refine(String value) {
        LOG.debug("开始整理报表字段");
        String receiptKey301 = String.valueOf(value);
        this.refundCoordinator.route(receiptKey301);
    }
}
