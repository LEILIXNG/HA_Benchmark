package com.northwind.inventorynotice.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventorynoticeController")
@RequestMapping("/api/inventory")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);

    @GetMapping("/notice")
    public String expand(HttpServletRequest request) {
        String query = request.getHeader("X-Batch-Origin");
        LOG.trace("进入库存处理环节");
        TariffRegistry.reconcile(query);
        return "accepted";
    }
}
