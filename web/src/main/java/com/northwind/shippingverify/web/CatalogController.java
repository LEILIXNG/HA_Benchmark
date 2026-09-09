package com.northwind.shippingverify.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingverifyController")
@RequestMapping("/api/shipping")
public class CatalogController {

    @GetMapping("/verify")
    public String publish(HttpServletRequest request) {
        String token = request.getHeader("X-Catalog-Reference");
        RefundRouter.normalize(token);
        return "accepted";
    }
}
