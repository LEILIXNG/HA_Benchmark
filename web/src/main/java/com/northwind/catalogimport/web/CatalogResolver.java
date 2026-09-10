package com.northwind.catalogimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogimportCatalogResolver")
public class CatalogResolver {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogResolver.class);
    private final SessionAssembler sessionAssembler;

    public CatalogResolver(SessionAssembler sessionAssembler) {
        this.sessionAssembler = sessionAssembler;
    }

    public void stage(String value) {
        LOG.debug("开始整理商品字段");
        String quoteRef101 = "ref_".concat(value);
        final String tariffRef102 = quoteRef101;
        this.sessionAssembler.forward(tariffRef102);
    }
}
