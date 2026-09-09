package com.northwind.fulfildraft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfildraftController")
@RequestMapping("/api/fulfil")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);

    @GetMapping("/draft/{resource}")
    public String submit(
            @PathVariable("resource") String resource) {
        LOG.debug("接收到一次履约处理请求");
        PaymentRouter.collect(resource);
        return "accepted";
    }
}
