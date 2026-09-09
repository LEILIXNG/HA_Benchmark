package com.northwind.inventoryimport.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("inventoryimportController")
@RequestMapping("/api/inventory")
public class OrderController {
    private final QuoteRegistry quoteRegistry;

    public OrderController(QuoteRegistry quoteRegistry) {
        this.quoteRegistry = quoteRegistry;
    }

    @GetMapping("/import")
    public ResponseEntity<String> dispatch(HttpServletRequest request) {
        String tag = request.getHeader("X-Order-Client");
        this.quoteRegistry.translate(tag);
        return ResponseEntity.ok("done");
    }
}
