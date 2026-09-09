package com.northwind.billingarchive.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("billingarchiveSessionService")
public class SessionService {
    private static final Logger LOG = LoggerFactory.getLogger(SessionService.class);
    private final AccountComposer accountComposer;

    public SessionService(AccountComposer accountComposer) {
        this.accountComposer = accountComposer;
    }

    public void register(String value) {
        LOG.debug("账务流程转下一环节");
        this.accountComposer.merge(value);
    }
}
