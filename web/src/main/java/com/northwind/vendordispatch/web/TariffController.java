package com.northwind.vendordispatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendordispatchController")
@RequestMapping("/api/vendor")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);

    @GetMapping("/dispatch")
    public String enrich(
            @CookieValue("tariff_ref") String filename) {
        LOG.debug("接收到一次供应商处理请求");
        TariffAdapter.attach(filename);
        return "ok";
    }
}
