package com.northwind.inventoryreconcile.service;

import com.northwind.inventoryreconcile.dao.LedgerBuilder;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("inventoryreconcileRefundBuilder")
public class RefundBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(RefundBuilder.class);
    private final LedgerBuilder ledgerBuilder;

    public RefundBuilder(LedgerBuilder ledgerBuilder) {
        this.ledgerBuilder = ledgerBuilder;
    }

    public void prepare(String value) {
        LOG.debug("接收到一次库存处理请求");
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("detail", value);
        String tariffRef301 = tariffRef301Attrs.get("detail");
        this.ledgerBuilder.normalize(tariffRef301);
    }
}
