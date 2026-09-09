package com.northwind.accountreopen.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountreopenController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/api/account/reopen/{query}")
    public String reconcile(
            @PathVariable("query") String query) {
        LOG.debug("开始整理账户字段");
        ShipmentRegistry.merge(query);
        return "accepted";
    }
}
