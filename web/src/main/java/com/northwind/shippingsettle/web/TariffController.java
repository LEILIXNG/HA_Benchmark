package com.northwind.shippingsettle.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("shippingsettleController")
@RequestMapping("/api/shipping")
public class TariffController {
    private final BundleNormalizer bundleNormalizer;

    public TariffController(BundleNormalizer bundleNormalizer) {
        this.bundleNormalizer = bundleNormalizer;
    }

    @GetMapping("/settle/{resource}")
    public String dispatch(
            @PathVariable("resource") String resource) {
        this.bundleNormalizer.submit(resource);
        return "accepted";
    }
}
