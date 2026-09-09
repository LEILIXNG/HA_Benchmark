package com.northwind.customerquote.service;

import com.northwind.customerquote.dao.ReceiptCollector2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("customerquoteAccountAdapter")
public class AccountAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountAdapter.class);
    private final ReceiptCollector2 receiptCollector2;

    public AccountAdapter(ReceiptCollector2 receiptCollector2) {
        this.receiptCollector2 = receiptCollector2;
    }

    public void route(String value) {
        LOG.trace("进入客户处理环节");
        String receiptKey101 = "ref:" + value + ";";
        this.receiptCollector2.dispatch(receiptKey101);
    }
}
