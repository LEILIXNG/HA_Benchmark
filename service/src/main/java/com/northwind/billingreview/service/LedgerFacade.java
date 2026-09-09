package com.northwind.billingreview.service;

import com.northwind.billingreview.dao.CatalogBuilder;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("billingreviewLedgerFacade")
public class LedgerFacade {
    private final CatalogBuilder catalogBuilder;

    public LedgerFacade(CatalogBuilder catalogBuilder) {
        this.catalogBuilder = catalogBuilder;
    }

    public void collect(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.get("detail");
        this.catalogBuilder.merge(refundCode101);
    }
}
