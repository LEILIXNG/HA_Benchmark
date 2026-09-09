package com.northwind.customersubmit.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("customersubmitController")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final CatalogCollector catalogCollector;

    public CatalogController(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @GetMapping("/api/customer/submit")
    public String normalize(HttpServletRequest request) {
        String userName = request.getHeader("X-Catalog-Channel");
        LOG.debug("接收到一次客户处理请求");
        this.catalogCollector.publish(userName);
        return "ok";
    }
}
