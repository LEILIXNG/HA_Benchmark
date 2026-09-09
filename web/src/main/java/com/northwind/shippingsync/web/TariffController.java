package com.northwind.shippingsync.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingsyncController")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final OrderNormalizer orderNormalizer;

    public TariffController(OrderNormalizer orderNormalizer) {
        this.orderNormalizer = orderNormalizer;
    }

    @GetMapping("/api/shipping/sync")
    public String expand(
            @CookieValue("tariff_session") String userName) {
        LOG.trace("进入发运处理环节");
        this.orderNormalizer.submit(userName);
        return "accepted";
    }
}
