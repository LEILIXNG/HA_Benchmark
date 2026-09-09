package com.northwind.billingtransfer.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingtransferController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final RefundTranslator refundTranslator;

    public CatalogController(RefundTranslator refundTranslator) {
        this.refundTranslator = refundTranslator;
    }

    @GetMapping("/api/billing/transfer")
    public String resolve(HttpServletRequest request) {
        String resource = request.getHeader("X-Catalog-Trace");
        LOG.debug("接收到一次账务处理请求");
        this.refundTranslator.register(resource);
        return "done";
    }
}
