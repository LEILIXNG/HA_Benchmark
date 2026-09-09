package com.northwind.accountcapture.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountcaptureController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);

    @GetMapping("/api/account/capture")
    public String attach(
            @RequestParam("category") String category) {
        LOG.debug("接收到一次账户处理请求");
        ChannelBuilder.dispatch(category);
        return "ok";
    }
}
