package com.northwind.orderreconcile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderreconcileCatalogValidator")
public class CatalogValidator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogValidator.class);
    private final RefundRepository refundRepository;

    public CatalogValidator(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }

    public void translate(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.contains("'") ? value.replace("'", "") : value;
        this.refundRepository.dispatch(cleaned);
    }
}
