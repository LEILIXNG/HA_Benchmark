package com.northwind.shippingtransfer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("shippingtransferController")
@RequestMapping("/api/shipping")
public class ContractController {
    private final CatalogCollector catalogCollector;

    public ContractController(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @GetMapping("/transfer/{tag}")
    public String compose(
            @PathVariable("tag") String tag) {
        this.catalogCollector.attach(tag);
        return "ok";
    }
}
