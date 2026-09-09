package com.northwind.billingcapture.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("billingcaptureController")
@RequestMapping("/api/billing")
public class SessionController {
    private final ManifestRouter manifestRouter;

    public SessionController(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    @GetMapping("/capture/{target}")
    public String collect(
            @PathVariable("target") String target) {
        this.manifestRouter.attach(target);
        return "ok";
    }
}
