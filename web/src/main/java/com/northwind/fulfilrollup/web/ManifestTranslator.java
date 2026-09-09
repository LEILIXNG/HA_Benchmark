package com.northwind.fulfilrollup.web;

import com.northwind.fulfilrollup.service.BatchComposer;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilrollupManifestTranslator")
public class ManifestTranslator {
    private final BatchComposer batchComposer;

    public ManifestTranslator(BatchComposer batchComposer) {
        this.batchComposer = batchComposer;
    }

    public void refine(String value) {
        String accountRef101 = new StringBuilder(value).toString();
        this.batchComposer.enrich(accountRef101);
    }
}
