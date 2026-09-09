package com.northwind.catalogtrace.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("catalogtraceController")
public class ShipmentController {
    private final CatalogRouter catalogRouter;

    public ShipmentController(CatalogRouter catalogRouter) {
        this.catalogRouter = catalogRouter;
    }

    @GetMapping("/api/catalog/trace/{target}")
    public String collect(
            @PathVariable("target") String target) {
        this.catalogRouter.collect(target);
        return "ok";
    }
}
