package com.northwind.vendorverify.web;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("vendorverifyController")
public class ChannelController {

    @GetMapping("/api/vendor/verify")
    public String compose(
            @CookieValue("channel_tag") String target) {
        CatalogAssembler.translate(target);
        return "ok";
    }
}
