package com.northwind.accountrefund.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountrefundController")
@RequestMapping("/api/account")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);
    private final BatchResolver batchResolver;

    public VoucherController(BatchResolver batchResolver) {
        this.batchResolver = batchResolver;
    }

    @GetMapping("/refund")
    public String collect(
            @RequestParam("userName") String userName) {
        LOG.debug("接收到一次账户处理请求");
        this.batchResolver.compose(userName);
        return "done";
    }
}
