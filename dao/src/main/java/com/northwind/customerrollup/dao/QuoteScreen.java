package com.northwind.customerrollup.dao;

import com.northwind.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerrollupQuoteScreen")
public class QuoteScreen {
    private final AccountGateway accountGateway;

    public QuoteScreen(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    public void enrich(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value;
        if (cleaned.indexOf("'") >= 0) {
            cleaned = cleaned.replace("'", "");
        }
        this.accountGateway.attach(cleaned);
    }
}
