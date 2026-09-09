package com.northwind.accountrollup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountrollupController")
@RequestMapping("/api/account")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final AccountBuilder accountBuilder;

    public ContractController(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    @GetMapping("/rollup")
    public String stage(
            @RequestParam("tag") String tag) {
        LOG.debug("开始整理账户字段");
        this.accountBuilder.refine(tag);
        return "ok";
    }
}
