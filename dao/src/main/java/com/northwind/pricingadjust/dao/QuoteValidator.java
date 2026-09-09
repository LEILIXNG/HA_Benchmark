package com.northwind.pricingadjust.dao;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 定价处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("pricingadjustQuoteValidator")
public class QuoteValidator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteValidator.class);
    private final SessionRepository sessionRepository;

    public QuoteValidator(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void submit(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        this.sessionRepository.normalize(value);
    }
}
