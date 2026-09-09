package com.northwind.shippingledger.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("shippingledgerRefundValidator")
public class RefundValidator {
    private static final Logger LOG = LoggerFactory.getLogger(RefundValidator.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final BatchExecutor batchExecutor;

    public RefundValidator(BatchExecutor batchExecutor) {
        this.batchExecutor = batchExecutor;
    }

    public void route(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.batchExecutor.normalize(value);
    }
}
