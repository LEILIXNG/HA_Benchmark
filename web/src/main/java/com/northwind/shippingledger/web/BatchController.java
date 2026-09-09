package com.northwind.shippingledger.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingledgerController")
@RequestMapping("/api/shipping")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final ManifestBroker manifestBroker;

    public BatchController(ManifestBroker manifestBroker) {
        this.manifestBroker = manifestBroker;
    }

    @GetMapping("/ledger")
    public String resolve(HttpServletRequest request) {
        String query = request.getHeader("X-Batch-Tenant");
        LOG.debug("开始整理发运字段");
        this.manifestBroker.reconcile(query);
        return "accepted";
    }
}
