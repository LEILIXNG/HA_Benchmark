package com.northwind.ordermanifest.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("ordermanifestController")
public class CatalogController {

    @GetMapping("/api/order/manifest")
    public String submit(HttpServletRequest request) {
        String query = request.getHeader("X-Catalog-Client");
        ManifestAdapter.translate(query);
        return "done";
    }
}
