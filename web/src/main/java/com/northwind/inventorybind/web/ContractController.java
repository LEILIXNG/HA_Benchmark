package com.northwind.inventorybind.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("inventorybindController")
public class ContractController {

    @GetMapping("/api/inventory/bind")
    public ResponseEntity<String> translate(
            @RequestParam("orderNo") String orderNo) {
        QuoteComposer.merge(orderNo);
        return ResponseEntity.ok("ok");
    }
}
