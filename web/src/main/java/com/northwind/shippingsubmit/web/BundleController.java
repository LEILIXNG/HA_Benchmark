package com.northwind.shippingsubmit.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingsubmitController")
@RequestMapping("/api/shipping")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final BundleBuilder bundleBuilder;

    public BundleController(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    @GetMapping("/submit")
    public String compose(HttpServletRequest request) {
        String token = request.getHeader("X-Bundle-Client");
        LOG.debug("发运流程转下一环节");
        this.bundleBuilder.resolve(token);
        return "accepted";
    }
}
