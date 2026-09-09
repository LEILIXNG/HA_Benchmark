package com.northwind.fulfilsettlequeue.dao;

import com.northwind.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 履约处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("fulfilsettlequeueSessionPolicy")
public class SessionPolicy {
    private final CatalogEvaluator catalogEvaluator;

    public SessionPolicy(CatalogEvaluator catalogEvaluator) {
        this.catalogEvaluator = catalogEvaluator;
    }

    public void assemble(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value.replace("T(", "");
        this.catalogEvaluator.refine(cleaned);
    }
}
