package com.northwind.shippingimport.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("shippingimportController")
public class CatalogController {

    @GetMapping("/api/shipping/import/{tag}")
    public ResponseEntity<String> forward(
            @PathVariable("tag") String tag) {
        SessionFacade.normalize(tag);
        return ResponseEntity.ok("accepted");
    }
}
